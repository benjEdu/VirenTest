package persistence;

import application.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import persistence.DBConnectionPool;
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
    public boolean einfuegenTestergebnis(String id, boolean ergebnis) throws SQLException{
                Connection conn = DBConnectionPool.getConn();
        try {
            PreparedStatement insert = conn.prepareStatement("insert into testergebnisse (testpersonId, ergebniss) values (?,?)");
            insert.setInt(1, Integer.parseInt(id));            
            insert.setBoolean(2, ergebnis);
            insert.executeUpdate();
            
        } catch(SQLException ex){
            throw new SQLException(ex);
        }
        return true;
    }
    
    @Override
    public boolean aendernTestergebnis(String id, boolean ergebnis ) throws SQLException{
        Connection conn = DBConnectionPool.getConn();
        try {
            PreparedStatement insert = conn.prepareStatement("update testergebnisse set ergebniss = ? where testpersonid = ?");
            insert.setBoolean(1, ergebnis);
            insert.setString(2, id);            
            
           /* insert.executeUpdate();
            PreparedStatement delete = conn.prepareStatement("delete from testergebnisse where id = ?");
            delete.setString(1, id);
            delete.executeUpdate();
            insert = conn.prepareStatement("insert into testergebnisse (id, testergebnisse) values (?,?)");
            insert.setString(1, id);*/
            insert.executeUpdate();
            return true;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } 
    }
   /*     public Person lesenTestergebnis(int id, boolean ergebnis ) {
        Connection conn = DBConnectionPool.getConn();
         
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
}