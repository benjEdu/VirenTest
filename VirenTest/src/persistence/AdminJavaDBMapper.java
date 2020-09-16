
package persistence;

import application.Admin;
import application.Laborant;
import application.Mitarbeiter;
import application.Testperson;
import application.Verwaltung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benni
 */
public class AdminJavaDBMapper implements IAdminMapper{

    private boolean emailVergeben(Connection conn, Mitarbeiter m) throws SQLException{
        PreparedStatement readMail = conn.prepareStatement("select mitarbeiterid from mitarbeiter where email=?");
        readMail.setString(1, m.getEmail());
        ResultSet rs = readMail.executeQuery();
        if(rs.next()){
            if(m.getMitarbeiterId().equals(rs.getString(1))){
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }
    
    @Override
    public String einfuegenMitarbeiter(Mitarbeiter m) {
        Connection conn = getConn();
        try {
            if(emailVergeben(conn, m)){
                return "E-Mail bereits vergeben";
            }
            Integer adressId = null;
            PreparedStatement insertAdresse = conn.prepareStatement("insert into adressen (strasse, hsnr, stadt, plz, land) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            insertAdresse.setString(1, m.getStrasse());
            insertAdresse.setString(2, m.getHsNr());
            insertAdresse.setString(3, m.getStadt());
            insertAdresse.setString(4, m.getPlz());
            insertAdresse.setString(5, m.getLand());
            insertAdresse.executeUpdate();
            ResultSet rs = insertAdresse.getGeneratedKeys();
            if(rs.next()){
                adressId = rs.getInt(1);
            }
            
            Integer rollenId = null;
            PreparedStatement getRId = conn.prepareStatement("select rollenid from rollen where bezeichnung = ? ");
            getRId.setString(1, m.getClass().getSimpleName());
            rs = getRId.executeQuery();
            if(rs.next()){
                rollenId = rs.getInt(1);
            }
            
            
            PreparedStatement insert = conn.prepareStatement("insert into mitarbeiter (vname, nname, email, tel, rollenid, adressid) values (?,?,?,?,?,?)");
            insert.setString(1, m.getVname());
            insert.setString(2, m.getNname());
            insert.setString(3, m.getEmail());
            insert.setString(4, m.getTel());
            insert.setInt(5, rollenId);
            insert.setInt(6, adressId);
            insert.executeUpdate();
            conn.commit();
            return "Passt";
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return "Läuft nicht";
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public String aendernMitarbeiter(Mitarbeiter m) {
        Connection conn = getConn();
        try {
            if(emailVergeben(conn, m)){
                return "E-Mail bereits vergeben";
            }
            int id = Integer.parseInt(m.getMitarbeiterId());
            PreparedStatement select = conn.prepareStatement("select adressid from mitarbeiter where mitarbeiterid = ?");
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            
            PreparedStatement update = conn.prepareStatement("update mitarbeiter set vname = ?, nname = ?, email = ?, tel = ? where mitarbeiterid = ?");
            update.setString(1, m.getVname());
            update.setString(2, m.getNname());
            update.setString(3, m.getEmail());
            update.setString(4, m.getTel());
            update.setInt(5, id);
            
            update.executeUpdate();
            
            if(rs.next()){
                update = conn.prepareStatement("update adressen set strasse = ?, hsnr = ?, stadt = ?, plz = ?, land = ? where adressid = ?");
                update.setString(1, m.getStrasse());
                update.setString(2, m.getHsNr());
                update.setString(3, m.getStadt());
                update.setString(4, m.getPlz());
                update.setString(5, m.getLand());
                update.setInt(6, rs.getInt(1));
                update.executeUpdate();
            }
            
            return "Passt";
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return "Läuft nicht";
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public boolean loeschenMitarbeiter(int id) {
        Connection conn = getConn();
        try {
            PreparedStatement select = conn.prepareStatement("select adressid from mitarbeiter where mitarbeiterid = ?");
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            
            PreparedStatement delete = conn.prepareStatement("delete from mitarbeiter where mitarbeiterid = ?");
            delete.setInt(1, id);
            delete.executeUpdate();
            
            if(rs.next()){
                delete = conn.prepareStatement("delete from adressen where adressid = ?");
                delete.setInt(1, rs.getInt(1));
                delete.executeUpdate();
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public List<Mitarbeiter> lesenAlleMitarbeiter() {
        List<Mitarbeiter> alle = new ArrayList<>();
        Connection conn = getConn();
        try {
            PreparedStatement select = conn.prepareStatement("select bezeichnung, mitarbeiterid, vname, nname, email, tel, adressid from mitarbeiter a, rollen b where a.rollenid = b.rollenid");
            ResultSet rs = select.executeQuery();
            while(rs.next()){
                PreparedStatement select2 = conn.prepareStatement("select adressid, strasse, hsnr, stadt, plz, land from adressen where adressid = ?");
                select2.setInt(1, rs.getInt(7));
                ResultSet rs2 = select2.executeQuery();
                Mitarbeiter p = null;
                if(rs.getString(1).trim().equals("Verwaltung") ){
                    p = new Verwaltung(rs.getString(2));
                } else if(rs.getString(1).trim().equals("Admin")){
                    p = new Admin(rs.getString(2));
                } else if(rs.getString(1).trim().equals("Laborant")){
                    p = new Laborant(rs.getString(2));
                }
                if(rs2.next()){
                    p.setStrasse(rs2.getString(2));
                    p.setHr(rs2.getString(3));
                    p.setStadt(rs2.getString(4));
                    p.setPlz(rs2.getString(5));
                    p.setLand(rs2.getString(6));
                }
                p.setVname(rs.getString(3));
                p.setNname(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setTel(rs.getString(6));
                alle.add(p);
            }
            return alle;
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public Mitarbeiter lesenMitarbeiter(int id) {
        Connection conn = getConn();
        try {
            Mitarbeiter p = null;
            PreparedStatement select = conn.prepareStatement("select bezeichnung, mitarbeiterid, vname, nname, email, tel, adressid from mitarbeiter a, rollen b where a.rollenid = b.rollenid and mitarbeiterid = ?");
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();
            if(rs.next()){
                if(rs.getString(1).trim().equals("Verwaltung") ){
                    p = new Verwaltung(rs.getString(2));
                } else if(rs.getString(1).trim().equals("Admin")){
                    p = new Admin(rs.getString(2));
                } else if(rs.getString(1).trim().equals("Laborant")){
                    p = new Laborant(rs.getString(2));
                }
                PreparedStatement select2 = conn.prepareStatement("select adressid, strasse, hsnr, stadt, plz, land from adressen where adressid = ?");
                select2.setInt(1, rs.getInt(7));
                ResultSet rs2 = select2.executeQuery();
                if(rs2.next()){
                    p.setStrasse(rs2.getString(2));
                    p.setHr(rs2.getString(3));
                    p.setStadt(rs2.getString(4));
                    p.setPlz(rs2.getString(5));
                    p.setLand(rs2.getString(6));
                }
                p.setVname(rs.getString(3));
                p.setNname(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setTel(rs.getString(6));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally{
            deleteConn(conn);
        }
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
    
    /**
     * nicht threadsafe!
     *
     * Aufraeumarbeiten
     */
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
