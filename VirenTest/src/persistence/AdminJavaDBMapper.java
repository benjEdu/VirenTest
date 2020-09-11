package persistence;

import application.Mitarbeiter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benni
 */
public class AdminJavaDBMapper implements IAdminMapper{

    @Override
    public boolean einfuegenMitarbeiter(Mitarbeiter m) {
        Connection conn = getConn();
        try {
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
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AdminJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
        finally{
            deleteConn(conn);
        }
    }

    @Override
    public boolean aendernMitarbeiter(Mitarbeiter m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loeschenMitarbeiter(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mitarbeiter lesenMitarbeiter(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mitarbeiter> lesenAlleMitarbeiter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
