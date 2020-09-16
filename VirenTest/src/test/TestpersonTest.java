/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.Testperson;
import persistence.VerwaltungJavaDBMapper;

/**
 *
 * @author z003ub8r
 */
public class TestpersonTest {
    public static void main(String[] args){
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
        Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "94649", "Deutschelaaand", "Passwort");
        Testperson tp2 = new Testperson("2Sentiten", "2Dimitri", "2test@testmail.com", "2456498", "25", "2laikestrasse", "2Bonn", "29469", "2Deutschelaaand", "Passwort2");
        Testperson tp3 = new Testperson("3Sentiten", "3Dimitri", "3test@testmail.com", "3456498", "35", "3laikestrasse", "3Bonn", "39469", "3Deutschelaaand", "Passwort3");
    
        System.out.println(einfuegenTest(mapper, tp));
        System.out.println(aendernTest(mapper, tp, tp2));
        
    
    }
    public static boolean einfuegenTest(VerwaltungJavaDBMapper mapper, Testperson tp){
        String einfuegen = mapper.einfuegenTestperson(tp);
        if(einfuegen.equals("Testperson erfolgreich eingefügt :)")){
            return true;
        }
        
        //bereits vorhandene Mail einfuegen
        einfuegen = mapper.einfuegenTestperson(tp);
        if(einfuegen.equals("Diese Email-Adresse ist bereits vergeben")){
            return true;
        }else{
                return false;
        }

    }
    
    
    public static boolean aendernTest(VerwaltungJavaDBMapper mapper, Testperson tp, Testperson tp2){
        tp2.setTestpersonId(tp.getTestpersonId());
        String aendern = mapper.aendernTestperson(tp2);
        if(aendern.equals("Erfolgreich geändert :)")){
            return true;
        }else{
            return false;
        }
    }
/*
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

    Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "9469", "Deutschelaaand");
    System.out.println(tp);*/
    
}
