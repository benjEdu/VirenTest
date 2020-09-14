package test;

import application.Mitarbeiter;
import application.Verwaltung;
import view.TestergebnisLesen;
import view.TestpersonEinfuegen;

public class Test{

    public static void main(String[] args) {
        /*Mitarbeiter t1 = new Verwaltung("1");
        t1.setEmail("test");
        System.out.println(t1.getEmail());
        */
        
        //new TestergebnisLesen("Virentestcenter");
        new TestpersonEinfuegen("Virentestcenter");
    }
    
}
