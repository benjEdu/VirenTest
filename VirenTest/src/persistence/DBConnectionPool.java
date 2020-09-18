/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author z003ub8r
 */
public class DBConnectionPool {
    static protected Connection getConn() {
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

    static protected void deleteConn(Connection conn) {
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
