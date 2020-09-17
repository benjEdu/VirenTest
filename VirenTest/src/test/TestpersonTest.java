/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.Testperson;
import persistence.VerwaltungJavaDBMapper;
import view.MitarbeiterLoginView;
import view.TestpersonenLoginView;

/**
 *
 * @author z003ub8r
 */
public class TestpersonTest {
    public static void main(String[] args){
        System.out.println(alleTesten());
    }
    
    public static String alleTesten(){
        String testergebnis = "";
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
        Testperson tp = new Testperson("Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "94649", "Deutschelaaand", "Passwort");
        Testperson tp2 = new Testperson("2Sentiten", "2Dimitri", "2test@testmail.com", "2456498", "25", "2laikestrasse", "2Bonn", "29469", "2Deutschelaaand", "Passwort2");
    
        boolean einfuegen = einfuegenTest(mapper, tp);
        boolean lesen = lesenTest(mapper, tp);
        boolean aendern = aendernTest(mapper, tp, tp2);
        boolean loeschen = loeschenTest(mapper, tp);
        
        //Einfuegen testen
        if(einfuegen){
            testergebnis+="\nEinfügen Test fehlerfrei durchlaufen";
        }else{
            testergebnis+="\nFehler beim Einfügen Test. Hierdurch failen auch der Lesen und der Löschen Test";
        }
        
        //Lesen testen
        if(lesen){
            testergebnis+="\nLesen Test fehlerfrei durchlaufen.";
        }else{
            testergebnis+="\nFehler beim Lesen.";
        }
        
        //Aendern testen
        if(aendern){
            testergebnis+="\nändern Test fehlerfrei durchlaufen";
        }else{
            testergebnis+="\nFehler beim ändern Test. Hierdurch failen auch der Lesen und der Löschen Test";
        }
        
        //Loeschen testen
        if(loeschen){
            testergebnis+="\nLöschen Test fehlerfrei durchlaufen";
        }else{
            testergebnis+="\nFehler beim Löschen Test. Hierdurch failen auch der Lesen und der Löschen Test";
        }
        
        return testergebnis;
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
    
    //Hierfür muss auch einfuegenTestperson funktionieren
    public static boolean lesenTest(VerwaltungJavaDBMapper mapper, Testperson tp){
        mapper.einfuegenTestperson(tp);
        Testperson tp2 = mapper.lesenTestperson(tp.getTestpersonId());
        if(tp.getVname().equals(tp2.getVname())){
            if(tp.getNname().equals(tp2.getNname())){
                if(tp.getEmail().equals(tp2.getEmail())){
                    if(tp.getAdressId()==tp.getAdressId()){
                        if(tp.getTel().equals(tp2.getTel())){
                            if(tp.getHsNr().equals(tp2.getHsNr())){
                                if(tp.getStrasse().equals(tp2.getStrasse())){
                                    if(tp.getStadt().equals(tp2.getStadt())){
                                        if(tp.getPlz().equals(tp2.getPlz())){
                                            if(tp.getLand().equals(tp2.getLand())){
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                        
                }
            }
        }
        return false;
    }
    
    public static boolean loeschenTest(VerwaltungJavaDBMapper mapper, Testperson tp){
      String ef = mapper.einfuegenTestperson(tp);
      if(lesenTest(mapper, tp)==false){
          return false;
      }
      mapper.loeschenTestperson(tp.getTestpersonId());
      boolean lt = lesenTest(mapper, tp);
      if(lt == false){
          return true;
      }
      return false;
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
