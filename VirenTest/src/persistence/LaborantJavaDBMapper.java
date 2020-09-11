package persistence;

import application.Person;
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
public class LaborantJavaDBMapper implements ILaborantMapper{

    @Override
    public boolean einfuegenTestergebnis(String id, boolean ergebnis) {
                Connection conn = getConn();
        try {
            PreparedStatement insert = conn.prepareStatement("insert into testergebnisse (testpersonId, ergebniss) values (?,?)");
            insert.setInt(1, Integer.parseInt(id));            
            insert.setBoolean(2, ergebnis);
            insert.executeUpdate();
            
        } catch(SQLException ex){
            Logger.getLogger(LaborantJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean aendernTestergebnis(int id, boolean ergebnis ) {
        Connection conn = getConn();
        try {
            PreparedStatement insert = conn.prepareStatement("update testergebnisse set ergebnis = ? where id = ?");
            insert.setInt(1, id);            
            insert.setBoolean(2, ergebnis);
            insert.executeUpdate();
            PreparedStatement delete = conn.prepareStatement("delete from testergebnisse where id = ?");
            delete.setInt(1, id);
            delete.executeUpdate();
            insert = conn.prepareStatement("insert into testergebnisse (id, testergebnisse) values (?,?)");
            insert.setInt(1, id);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LaborantJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
   /*     public Person lesenTestergebnis(int id, boolean ergebnis ) {
        Connection conn = getConn();
         
        try {
            PreparedStatement insert = conn.prepareStatement("select testergebnisse from personen where id = ?");
            insert.setInt(1, id);
            ResultSet rs = insert.executeQuery();

            return testergebnisse;
        } catch (SQLException ex) {
            Logger.getLogger(LaborantJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }*/
    
            private  Connection getConn() {
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

    public boolean ergebnisAbrufen(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

        

            
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
