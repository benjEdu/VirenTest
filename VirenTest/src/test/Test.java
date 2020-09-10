/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import application.Mitarbeiter;
import application.Verwaltung;

/**
 *
 * @author z003ub8r
 */
public class Test{

    public static void main(String[] args) {
        Mitarbeiter t1 = new Verwaltung("1");
        t1.setEmail("test");
        System.out.println(t1.getEmail());
    }
    
}
