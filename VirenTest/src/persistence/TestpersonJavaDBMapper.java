package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestpersonJavaDBMapper implements ITestpersonMapper {

    @Override
    public boolean ergebnisAbrufen(String testpersonId) {

        Connection conn = getConn();
        try {
            PreparedStatement read = conn.prepareStatement("select ergebniss from testergebnisse te NATURAL JOIN testpersonen tp where tp.testpersonId = ?");
            read.setInt(1, Integer.parseInt(testpersonId));
            ResultSet rs = read.executeQuery();
            boolean ergebnis;
            if (rs.next()) {
                ergebnis = rs.getBoolean(1);
            } else {
                return false;
            }
            return ergebnis;
        } catch (SQLException ex) {
            Logger.getLogger(TestpersonJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
