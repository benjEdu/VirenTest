package test;

import application.Laborant;
import application.Mitarbeiter;
import application.Person;
import application.Testperson;
import application.Verwaltung;
import java.util.List;
import view.TestergebnisLesen;
import persistence.VerwaltungJavaDBMapper;
import view.MitarbeiterAendernView;
import view.MitarbeiterEinfuegen;
import view.MitarbeiterVerwaltungView;
import view.TestpersonEinfuegen;
import view.TestpersonLoeschen;
import view.TestpersonenVerwaltungView;
import view.ViewLaborant;
import view.TestpersonAendern;
import view.TestpersonenVerwaltungstabelle;
import view.VirenTestcenterView;

public class Test{

    public static void main(String[] args) {
        
        /*
        
         System.out.println("Brombeere: "+Login.hashPassword("Brombeere", "c8a2ebb85d364556ba4d78cb9c9cd408", 0));
        System.out.println();
        System.out.println("Himbeere: "+Login.hashPassword("Himbeere", "1a7041115399402e9022c0eb03143ec5", 0));
        System.out.println();
        System.out.println("Erdbeere: "+Login.hashPassword("Erdbeere", "8ceb6b9c0971495d97520e37f969d471", 0));
        System.out.println();
        System.out.println("Heidelbeere: "+Login.hashPassword("Heidelbeere", "4d1e6125e8ba4383b003d91b584cf7fd", 0));
        System.out.println();
        System.out.println("Banane: "+Login.hashPassword("Banane", "7744724870154dfe8e8c05e5d357364e", 0));
        System.out.println();
        System.out.println("Ananas: "+Login.hashPassword("Ananas", "6aa5b8269bba4a1985d51c2b2ac6c87d", 0));
        System.out.println();
        System.out.println("Apfel: "+Login.hashPassword("Apfel", "ba4d00e5c835481d8312d927831d522f", 0));
        System.out.println();
        System.out.println("Pfirsich: "+Login.hashPassword("Pfirsich", "63c5db93e725465aaa57a33acba533b0", 0));
        LoginView lv = new LoginView("Login");
        
        
        
          
        
        Testperson tp2 = new Testperson("2Sentiten", "2Dimitri", "2test@testmail.com", "2456498", "25", "2laikestrasse", "2Bonn", "29469", "2Deutschelaaand");
        System.out.println(tp);
        System.out.println(tp2);
        System.out.println("\n\nEinfügen");
        System.out.println(mapper.einfuegenTestperson(tp));
        mapper.lesenTestperson(tp.getTestpersonId());
        
        System.out.println("\n\nAendern");
        System.out.println(mapper.aendernTestperson(tp2));
        
        System.out.println("\n\nLesen beide ");
        System.out.println(mapper.lesenTestperson(tp.getTestpersonId()));
        System.out.println(mapper.lesenTestperson(tp2.getTestpersonId()));
        
        System.out.println("\n\nLesen alle");
        System.out.println(mapper.lesenAlleTestpersonen());
        
        System.out.println("\n\nLöschen beide");
        System.out.println(mapper.loeschenTestperson(tp.getTestpersonId()));
        System.out.println(mapper.loeschenTestperson(tp2.getTestpersonId()));
                
        */
        
        //Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "9469", "Deutschelaaand");
        //System.out.println(tp);
        
        //new TestergebnisLesen("Virentestcenter", 1);
        
        //new ViewLaborant("Virentestcenter");
        //new TestpersonEinfuegen("Virentestcenter");
        //new TestpersonLoeschen("Virentestcenter");
        //new MitarbeiterEinfuegen("Virentestcenter");
        
        //mapper.einfuegenTestperson(tp);
        //List<Testperson> test = mapper.lesenAlleTestpersonen();
        //System.out.println(test);
        //mapper.lesenTestperson(1);
        
        //new TestpersonenVerwaltungView("Virentestcenter");
        //Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "9469", "Deutschland");
        //Testperson tp2 = new Testperson(17);
        //new TestpersonAendern("Virentestcenter", tp2);
        
        /*
       Mitarbeiter tp = new Laborant("15");
       tp.setEmail("test");
       tp.setHr("1");
       tp.setLand("DE");
       tp.setNname("test");
       tp.setPlz("test");
       tp.setStadt("test");
       tp.setStrasse("test");
       tp.setTel("test");
       tp.setVname("test");
       
       new MitarbeiterVerwaltungView("Virentestcenter");
       //new MitarbeiterAendernView("Virentestcenter", tp);
       */
        
        /*
        Testperson tp2 = new Testperson(17);
        tp2.setEmail("test");
        tp2.setHr("1");
        tp2.setLand("DE");
        tp2.setNname("test");
        tp2.setPlz("test");
        tp2.setStadt("test");
        tp2.setStrasse("test");
        tp2.setTel("test");
        tp2.setVname("test");
        
        Testperson tp3 = new Testperson(17);
        tp3.setEmail("bla");
        tp3.setHr("bla");
        tp3.setLand("bla");
        tp3.setNname("bla");
        tp3.setPlz("bla");
        tp3.setStadt("bla");
        tp3.setStrasse("bla");
        tp3.setTel("bla");
        tp3.setVname("bla");
        
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
        System.out.println(tp2.toString());
        System.out.println(mapper.aendernTestperson(tp3));
        mapper.aendernTestperson(tp3);
        System.out.println(tp2.toString());
        
       
                */
        //new TestpersonenVerwaltungstabelle("Virentestcenter");
        
        //new MitarbeiterVerwaltungView("Virentestcenter"); 
        
        new VirenTestcenterView("Virentestcenter");
}
}
