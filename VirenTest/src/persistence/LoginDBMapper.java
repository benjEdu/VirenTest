/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import application.Login;
import application.Person;
import application.Testperson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DBConnectionPool;

/**
 *
 * @author z003ub8r
 */
public class LoginDBMapper implements ILoginMapper{

    public LoginDBMapper(){
        
    }

    @Override
    public Testperson einloggen(String email, String pwd) {
        Connection conn = DBConnectionPool.getConn();
        try{
            //Todo: Woher wissen wir, ob eine Person ein Mitarbeiter, oder eine Testperson ist? 
            //Derweil ist die Funktion nur fuer eine Testperson geschrieben
            PreparedStatement read = conn.prepareStatement("select * from testpersonen where LOWER(email)=?");
            read.setString(1, email.toLowerCase());
            ResultSet rs = read.executeQuery();
            //Email ist unique, daher kann hier nur maximalein Ergebnis vorliegen
            if(rs.next()){
                String dbPwdHash = rs.getString("pwdhash");
                String dbSalt = rs.getString("salt");
                
                //Eingegebenes Passwort hashen
                String pwdHash = Login.hashPassword(pwd, dbSalt);
                if(pwdHash.equals(dbPwdHash)){
                    Testperson tp;
                    String Vname = rs.getString("vname");
                    String Nname = rs.getString("nname");
                    String Email = rs.getString("email");
                    String tel = rs.getString("tel");
                    int adressId = rs.getInt("adressId");
                    read = conn.prepareStatement("select * from adressen where adressId = ?");
                    read.setInt(1, adressId);
                    ResultSet rs2 = read.executeQuery();
                    if(rs2.next()){
                        String strasse = rs2.getString("strasse");
                        String hsNr = rs2.getString("hsNr");
                        String stadt = rs2.getString("Stadt");
                        String plz = rs2.getString("plz");
                        String land = rs2.getString("land");
                        tp = new Testperson(adressId, Nname, Vname, Email, tel, hsNr, strasse, stadt, plz, land);
                    }else{
                        tp = new Testperson(Nname, Vname, Email, tel);
                    }
                    return tp;
                }
            }
            //Falls die Email nicht gefunden wurde, oder das Passwort falsch ist
            return null;
        }catch (SQLException exl){
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, exl);
        }finally{
            DBConnectionPool.deleteConn(conn);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
