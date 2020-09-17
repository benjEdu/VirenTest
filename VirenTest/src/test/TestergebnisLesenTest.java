/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.LaborantVerwaltung;
import application.Testperson;
import application.TestpersonenVerwaltung;
import application.VerwaltungVerwaltung;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.LaborantJavaDBMapper;

/**
 *
 * @author z003sdxk
 */
public class TestergebnisLesenTest {
    public static void main(String[] args){
        System.out.println("Test TestergebnisLesen gestartet");
        
        TestpersonenVerwaltung tpv = new TestpersonenVerwaltung();
        LaborantVerwaltung lv = new LaborantVerwaltung();
        VerwaltungVerwaltung vv = new VerwaltungVerwaltung();
                                                                                                                                                                                                                                                                                     
        Testperson tp1 = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "94649", "Deutschland", "Passwort");
        Testperson tp2 = new Testperson("2Sentiten", "2Dimitri", "2test@testmail.com", "2456498", "25", "2laikestrasse", "2Bonn", "29469", "2Deutschland", "Passwort2");
               
        vv.einfuegenTestperson(tp1);
        vv.einfuegenTestperson(tp2);
        
        int i = getMaxId();
        
        String tpId1 = String.valueOf(i-1);
        String tpId2 = String.valueOf(i);
        
        try {
            lv.einfuegenTestergebnis(tpId1, true);
            lv.einfuegenTestergebnis(tpId2, false);
        } catch (SQLException ex) {
            Logger.getLogger(TestergebnisLesenTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        ergebnisAbrufenTestPositiv(tpv, i-1);
        ergebnisAbrufenTestNegativ(tpv, i);
        
        vv.loeschenTestperson(i-1);
        vv.loeschenTestperson(i);
                
        System.out.println("Test TestergebnisLesen beendet");
    }
    
    public static String ergebnisAbrufenTestPositiv(TestpersonenVerwaltung tpv, int tpId){
        
        String abgerufen = tpv.ergebnisAbrufen(tpId);
        if(abgerufen.equals("Positiv")){ //Wenn Testergebnis Positiv ist
            return "Positiv";  //Rückgabe True
        }else {
            return "TestergebnisLesen gescheitert";
        }
    }
    
    public static String ergebnisAbrufenTestNegativ(TestpersonenVerwaltung tpv, int tpId){
        String abgerufen = tpv.ergebnisAbrufen(tpId);
        if(abgerufen.equals("Negativ")){ //Wenn Testergebnis Positiv ist
            return "Negativ";  //Rückgabe True
        }else {
            return "TestergebnisLesen gescheitert";
        }
    }
    
    public static int getMaxId () {
        Connection conn = getConn();
        try {
            PreparedStatement read = conn.prepareStatement("select MAX(testpersonId) AS alle FROM testpersonen");
            ResultSet rs = read.executeQuery();
            rs.next();
            int max = rs.getInt("alle");
            return max;
        } catch(SQLException ex){
            Logger.getLogger(LaborantJavaDBMapper.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
        private static Connection getConn() {
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
