/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.Admin;
import application.Mitarbeiter;
import java.sql.SQLException;
import persistence.AdminJavaDBMapper;
import view.MitarbeiterVerwaltungView;
/*Mitarbeiter m = new Admin("2");
         m.setEmail("test19@email.com");
         m.setHr("33");
         m.setLand("Deutschland");
         m.setNname("Mäder");
         m.setPlz("22301");
         m.setStadt("Hamburg");
         m.setStrasse("Hagedornstraße");
         m.setTel("04041339006");
         m.setVname("Benjamin");
         
         mapper.einfuegenMitarbeiter(m);*/
         
        
/**
 *
 * @author benni
 */
public class AdminTest {
     public static void main(String[] args) throws SQLException {
         AdminJavaDBMapper mapper = new AdminJavaDBMapper();
         
         // Aquivalenzklasse Standard: 
        // id Zahl >0 <=1000
        // Name mit korrekten Zeichen keine überflüssigen Blanks
        // korrekte Zeichen: a-Z, Umlaute, ß,à ....
        Mitarbeiter ad1 = new Admin("test");
        Mitarbeiter ad2 = new Admin(null);
        
        Mitarbeiter ad3 = new Admin("test");
        ad3.setEmail("test");
        ad3.setHr("test");
        ad3.setLand("test");
        ad3.setNname("test");
        ad3.setPlz("81549");
        ad3.setStadt("MUC");
        ad3.setStrasse("test");
        ad3.setTel("0174");
        ad3.setVname("test");
        
        try{
            String testAd1 = mapper.einfuegenMitarbeiter(ad1);
            System.out.println(testAd1);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            String testAd2 = mapper.einfuegenMitarbeiter(ad2);
            System.out.println(testAd2);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            String testAd3 = mapper.einfuegenMitarbeiter(ad3);
            System.out.println(testAd3);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        
         
     }
}
