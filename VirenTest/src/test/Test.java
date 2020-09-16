package test;

import application.Mitarbeiter;
import application.Testperson;
import application.Verwaltung;
import java.util.List;
import view.TestergebnisLesen;
import persistence.VerwaltungJavaDBMapper;
import view.MitarbeiterEinfuegen;
import view.TestpersonEinfuegen;
import view.TestpersonLoeschen;
import view.TestpersonenVerwaltungView;
import view.ViewLaborant;
import view.TestpersonAendern;

public class Test{

    public static void main(String[] args) {
        
        /*
        
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
          
        
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
        
       
    }
}
