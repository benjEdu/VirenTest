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
import view.MitarbeiterLesen;
import view.MitarbeiterVerwaltungView;
import view.VirenTestcenterView;
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
         
        /*  // Aquivalenzklasse Standard: 
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
        
        Mitarbeiter ad4 = new Admin("8");
        ad4.setEmail("test");
        ad4.setHr("test");
        ad4.setLand("test");
        ad4.setNname("test");
        ad4.setPlz("81549");
        ad4.setStadt("MUC");
        ad4.setStrasse("test");
        ad4.setTel("0174");
        ad4.setVname("test");
        
        Mitarbeiter ad5 = new Admin(null);
        
        try{
            String testAd1 = mapper.einfuegenMitarbeiter(ad1);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            String testAd2 = mapper.einfuegenMitarbeiter(ad2);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            String testAd3 = mapper.einfuegenMitarbeiter(ad3);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        try{
            String testAd4 = mapper.aendernMitarbeiter(ad4);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            String testAd5 = mapper.aendernMitarbeiter(ad5);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        try{
            boolean testAd6 = mapper.loeschenMitarbeiter(8);
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        */
         
        Mitarbeiter ad4 = new Admin("8");
        ad4.setEmail("test");
        ad4.setHr("test");
        ad4.setLand("test");
        ad4.setNname("test");
        ad4.setPlz("81549");
        ad4.setStadt("MUC");
        ad4.setStrasse("test");
        ad4.setTel("0174");
        ad4.setVname("test");
        
        //new MitarbeiterLesen("Test", ad4);
        
        new MitarbeiterVerwaltungView("Test");
        
        
     }
}
