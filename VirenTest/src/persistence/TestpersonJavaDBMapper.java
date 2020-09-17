package persistence;

import application.Testperson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestpersonJavaDBMapper implements ITestpersonMapper {

    @Override
    public String ergebnisAbrufen(int testpersonId) {

        Connection conn = getConn();
        try {
            PreparedStatement read = conn.prepareStatement("select ergebniss from testergebnisse te NATURAL JOIN testpersonen tp where tp.testpersonId = ?");
            read.setInt(1, testpersonId);
            ResultSet rs = read.executeQuery();
            boolean ergebnis;  //True bei positivem Test; False bei negativem Test
            if (rs.next()) {
                ergebnis = rs.getBoolean(1);
            } else {
                return "Ergebnis noch nicht vorhanden";
            }
            if(ergebnis){
                return "Positiv";
            } else {
                return "Negativ";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestpersonJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return "Error";
        } finally {
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
