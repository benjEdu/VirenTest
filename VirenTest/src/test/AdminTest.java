/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.Admin;
import application.Mitarbeiter;
import persistence.AdminJavaDBMapper;
import view.MitarbeiterVerwaltungView;

/**
 *
 * @author benni
 */
public class AdminTest {
     public static void main(String[] args) {
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
         AdminJavaDBMapper mapper = new AdminJavaDBMapper();
         mapper.einfuegenMitarbeiter(m);*/
         
         new MitarbeiterVerwaltungView("Verwaltung");
     }
}
