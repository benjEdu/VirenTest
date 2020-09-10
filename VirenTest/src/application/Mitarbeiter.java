/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author benni
 */
public abstract class Mitarbeiter extends Person{

    private final String mitarbeiterId;
    
    public Mitarbeiter(String mitarbeiterId) {
        super();
        this.mitarbeiterId = mitarbeiterId;
    }

    public String getMitarbeiterId() {
        return mitarbeiterId;
    }
    
    
    
}
