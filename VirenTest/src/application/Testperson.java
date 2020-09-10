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
public class Testperson extends Person{

    private static int testpersonId;
    private int adressId;
    
    public Testperson(int testpersonId, int adressId) {
        super();
        this.testpersonId = testpersonId;
        this.adressId = adressId;
    }
    
    public Testperson(int testpersonId) {
        super();
        this.testpersonId = testpersonId;
    }

    public Testperson(int adressId, String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land) {
        super(nname, vname, email, tel, hsNr, strasse, stadt, plz, land);
        this.adressId = adressId;
        this.testpersonId = testpersonId;
    }
    
    

    public int getTestpersonId() {
        return testpersonId;
    }
    
    public int getAdressId() {
        return adressId;
    }
    
    public void setAdressId(int adressId){
        this.adressId = adressId;
    }
    
    
}
