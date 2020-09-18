package persistence;

import application.Testperson;
import persistence.DBConnectionPool;
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

        Connection conn = DBConnectionPool.getConn();
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
            DBConnectionPool.deleteConn(conn);
        }

    }
}
