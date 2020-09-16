package test;

import application.Login;
import application.Mitarbeiter;
import application.Testperson;
import application.Verwaltung;
import java.util.List;
import view.TestergebnisLesen;
import persistence.VerwaltungJavaDBMapper;
import view.LoginView;
import view.MitarbeiterEinfuegen;
import view.TestpersonEinfuegen;
import view.TestpersonLoeschen;
import view.TestpersonenVerwaltungView;
import view.ViewLaborant;

public class Test{

    public static void main(String[] args) {

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
        /*
        
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
          
        Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "9469", "Deutschelaaand");
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
        
        //new TestergebnisLesen("Virentestcenter", 2);
        
        //new ViewLaborant("Virentestcenter");
        //new TestpersonEinfuegen("Virentestcenter");
        //new TestpersonLoeschen("Virentestcenter");
        //new MitarbeiterEinfuegen("Virentestcenter");
        
        //mapper.einfuegenTestperson(tp);
        //List<Testperson> test = mapper.lesenAlleTestpersonen();
        //System.out.println(test);
        //mapper.lesenTestperson(1);
        
        //new TestpersonenVerwaltungView("Virentestcenter");
        
       
    }
}
