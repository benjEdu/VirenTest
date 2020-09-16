
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Login;
import application.Testperson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benni
 */
public class VerwaltungJavaDBMapper implements IVerwaltungMapper{
    
    private boolean emailVergeben(Connection conn, Testperson tp) throws SQLException{
        PreparedStatement readMail = conn.prepareStatement("select * from testpersonen where email=?");
        readMail.setString(1, tp.getEmail());
        ResultSet rs = readMail.executeQuery();
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String einfuegenTestperson(Testperson tp) {
        int adressId = 0;
        Connection conn = getConn();
        try{
            conn.setAutoCommit(false);
            if(emailVergeben(conn,tp)){
                return "Diese Email-Adresse ist bereits vergeben";
            }
            //Adresse der Testperson einfuegen
            PreparedStatement insert = conn.prepareStatement("insert into adressen(strasse,hsnr,stadt,plz,land)values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setString(1, tp.getStrasse());
            insert.setString(2, tp.getHsNr());
            insert.setString(3, tp.getStadt());
            insert.setString(4, tp.getPlz());
            insert.setString(5, tp.getLand());
            insert.executeUpdate();
            conn.commit();
            ResultSet rs = insert.getGeneratedKeys();

            if(rs.next()){
                adressId = rs.getInt(1);
            }
        }catch (SQLException exl){
                Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, exl);
        }
        
        //Testperson selbst einfuegen
        try {
            conn.setAutoCommit(false);
            
            //generiert einen zufälligen 32 Zeichen langen String, der als Salt dient
            //Moin Benny
            final String salt = Login.getSalt();
            String pwdHash = Login.hashPassword(salt, tp.getPwd());
            
            PreparedStatement insert = conn.prepareStatement("insert into testpersonen (vname, nname, email, tel,adressId, salt, pwdhash) values (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            insert.setString(1, tp.getVname());
            insert.setString(2, tp.getNname());
            insert.setString(3, tp.getEmail());
            insert.setString(4, tp.getTel());
            insert.setInt(5, adressId);
            insert.setString(6, salt);
            insert.setString(7, pwdHash);
            insert.executeUpdate();
            conn.commit();
            ResultSet rs = insert.getGeneratedKeys();

            //TODO
            if(rs.next()){
                int tpId = rs.getInt(1);
                tp.setTestpersonId(tpId);
            }
            return "Testperson erfolgreich eingefügt :)";
        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            try{
                conn.rollback();
            }catch (SQLException exl){
                Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, exl);
            }
            return ex.toString();
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public String aendernTestperson(Testperson tp) {
        Connection conn = getConn();
        try{
            conn.setAutoCommit(false);
            if(emailVergeben(conn,tp)){
                return "Diese Email-Adresse ist bereits vergeben";
            }
            PreparedStatement update = conn.prepareStatement("update testpersonen set vname=?, nname=?, email=?, tel=?, adressid=? where testpersonid=?");
                    update.setString(1, tp.getVname());
                    update.setString(2, tp.getNname());
                    update.setString(3, tp.getEmail());
                    update.setString(4, tp.getTel());
                    update.setInt(5, tp.getAdressId());
                    update.setInt(6, tp.getTestpersonId());
                    update.executeUpdate();
            update = conn.prepareStatement("update adressen set strasse=?, hsnr=?, stadt=?, plz=?, land=? where adressid=?");
                    update.setString(1, tp.getStrasse());
                    update.setString(2, tp.getHsNr());
                    update.setString(3, tp.getStadt());
                    update.setString(4, tp.getPlz());
                    update.setString(5, tp.getLand());
                    update.setInt(6, tp.getAdressId());
                    update.executeUpdate();
                    conn.commit();
                    return "Erfolgreich geändert :)";
        }catch (SQLException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public boolean loeschenTestperson(int tpid) {
        Connection conn = getConn();
        try {
            PreparedStatement delete = conn.prepareStatement("delete from testergebnisse where testpersonid = ?");
            delete.setInt(1, tpid);
            delete.executeUpdate();
            delete = conn.prepareStatement("delete from testpersonen where testpersonid = ?");
            delete.setInt(1, tpid);
            delete.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public Testperson lesenTestperson(int tpid) {
        Connection conn = getConn();
        try{
            PreparedStatement read = conn.prepareStatement("select * from testpersonen where testpersonid = ?");
            read.setInt(1, tpid);
            ResultSet rs = read.executeQuery();
            if(rs.next()){
                String Vname = rs.getString("vname");
                String Nname = rs.getString("nname");
                String Email = rs.getString("email");
                String tel = rs.getString("tel");
                int adressId = rs.getInt("adressId");
                String salt = rs.getString("salt");
                String pwdHash = rs.getString("pwdHash");
                read = conn.prepareStatement("select * from adressen where adressId = ?");
                read.setInt(1, adressId);
                ResultSet rs2 = read.executeQuery();
                if(rs2.next()){
                    String strasse = rs2.getString("strasse");
                    String hsNr = rs2.getString("hsNr");
                    String stadt = rs2.getString("Stadt");
                    String plz = rs2.getString("plz");
                    String land = rs2.getString("land");
                    Testperson tp = new Testperson(adressId, Nname, Vname, Email, tel, hsNr, strasse, stadt, plz, land, salt, pwdHash);
                    return tp;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        deleteConn(conn);
    }
        return null;
    }
    
    
    @Override
    public List<Testperson> lesenAlleTestpersonen() {
        List<Testperson> alleTestpersonen = new ArrayList<>();
        Connection conn = getConn();
        try{
            PreparedStatement read = conn.prepareStatement("select * from testpersonen");
            ResultSet rs = read.executeQuery();
            while(rs.next()){
                int tpId = rs.getInt("testpersonId");
                String Vname = rs.getString("vname");
                String Nname = rs.getString("nname");
                String Email = rs.getString("email");
                String tel = rs.getString("tel");
                int adressId = rs.getInt("adressId");
                String salt = rs.getString("salt");
                String pwdHash = rs.getString("pwdHash");
                read = conn.prepareStatement("select * from adressen where adressId = ?");
                read.setInt(1, adressId);
                ResultSet rs2 = read.executeQuery();
                Testperson tp;
                if(rs2.next()){
                    String strasse = rs2.getString("strasse");
                    String hsNr = rs2.getString("hsNr");
                    String stadt = rs2.getString("Stadt");
                    String plz = rs2.getString("plz");
                    String land = rs2.getString("land");
                    tp = new Testperson(adressId, Nname, Vname, Email, tel, hsNr, strasse, stadt, plz, land, salt, pwdHash);
                    tp.setTestpersonId(tpId);
                }else{
                    tp = new Testperson(Nname, Vname, Email, tel, salt, pwdHash);
                }
                alleTestpersonen.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            deleteConn(conn);
        }
        return alleTestpersonen;
    }
    
    private Connection getConn() {
        String userid = "VDB";
        String password = "123";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Virendatenbank";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userid, password);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } catch (SQLException e) {
            System.err.println("getConn" + e);
        }
        return conn;
    }

    private void deleteConn(Connection conn) {
        // solange noch kein Pool vorhanden 
        // nicht threadsafe
        try {
            // immer vorsichtshalber commit vor close
            conn.commit();
            // schließen
            conn.close();
            // aufraeumen
            conn = null;
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
}
