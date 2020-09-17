/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import application.Admin;
import application.Laborant;
import application.Login;
import application.Mitarbeiter;
import application.Person;
import application.Testperson;
import application.Verwaltung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DBConnectionPool;
import view.MitarbeiterVerwaltungView;
import view.TestpersonenVerwaltungView;
import view.ViewLaborant;

/**
 *
 * @author z003ub8r
 */
public class LoginDBMapper implements ILoginMapper{

    public LoginDBMapper(){
        
    }

    @Override 
    public Mitarbeiter mitarbeiterEinloggen(String email, String pwd){
        Connection conn = DBConnectionPool.getConn();
        try{
            PreparedStatement read = conn.prepareStatement("select * from mitarbeiter where LOWER(email)=?");
            read.setString(1, email.toLowerCase());
            ResultSet rs = read.executeQuery();
            //Email ist unique, daher kann hier nur maximalein Ergebnis vorliegen
            if(rs.next()){
                String dbPwdHash = rs.getString("pwdhash");
                String dbSalt = rs.getString("salt");
                
                //Eingegebenes Passwort hashen
                String pwdHash = Login.hashPassword(pwd, dbSalt);
                if(pwdHash.equals(dbPwdHash)){
                    String rollenId = rs.getString("rollenid");
                    String mitarbeiterId = rs.getString("mitarbieterid");
                    switch(rollenId){
                        case "1":
                            Admin a = new Admin(mitarbeiterId);
                            return a;
                        case "2":
                            Verwaltung v = new Verwaltung(mitarbeiterId);
                            return v;
                        case "3":
                            Laborant l = new Laborant(mitarbeiterId);
                            return l;
                    }
                }
            }
            //Falls die Email nicht gefunden wurde, oder das Passwort falsch ist
            return null;
        }catch (SQLException exl){
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, exl);
            return null;
        }finally{
            DBConnectionPool.deleteConn(conn);
        }
    }
    
    @Override
    public Testperson testpersonEinloggen(String email, String pwd) {
        Connection conn = DBConnectionPool.getConn();
        try{
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
            return null;
        }finally{
            DBConnectionPool.deleteConn(conn);
        }
    }  
}
