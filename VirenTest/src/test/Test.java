package test;

import application.Mitarbeiter;
import application.Testperson;
import application.Verwaltung;
import java.util.List;
import view.TestergebnisLesen;
import persistence.VerwaltungJavaDBMapper;

public class Test{

    public static void main(String[] args) {
        VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
          
        Testperson tp = new Testperson(1, "Sentiten", "Dimitri", "test@testmail.com", "456498", "5", "laikestrasse", "Bonn", "9469", "Deutschelaaand");
        System.out.println(tp);
        List<Testperson> test = mapper.lesenAlleTestpersonen();
        System.out.println(test);
    }
    
}
