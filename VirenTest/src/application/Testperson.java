package application;

public class Testperson extends Person{

    private int testpersonId;
    private int adressId;
    
    public Testperson(int testpersonId, int adressId) {
        super();
        this.testpersonId = testpersonId;
        this.adressId = adressId;
    }
    
    //Todo Anzahl Konstruktoren reduzieren
    public Testperson(int testpersonId) {
        super();
        this.testpersonId = testpersonId;
    }

    public Testperson(String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land, String salt, String pwdHash) {
        super(nname, vname, email, tel, hsNr, strasse, stadt, plz, land, salt, pwdHash);
        this.testpersonId = testpersonId;
    }
    
    public Testperson(int adressId, String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land, String salt, String pwdHash) {
        super(nname, vname, email, tel, hsNr, strasse, stadt, plz, land, salt, pwdHash);
        this.testpersonId = testpersonId;
        this.adressId = adressId;
    }
    
    public Testperson(int adressId, String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land) {
        super(nname, vname, email, tel, hsNr, strasse, stadt, plz, land);
        this.testpersonId = testpersonId;
        this.adressId = adressId;
    }

    public Testperson(String nname, String vname, String email, String tel, String salt, String pwdHash) {
        super(nname, vname, email, tel, salt, pwdHash);
    }
    public Testperson(String nname, String vname, String email, String tel) {
        super(nname, vname, email, tel);
    }

    public Testperson(String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land, String pwd){
        super(nname, vname, email, tel, hsNr, strasse, stadt, plz, land, pwd);
    }
    

    public int getTestpersonId() {
        return testpersonId;
    }
    
    public void setTestpersonId(int tpId){
        this.testpersonId = tpId;
    }
    
    public int getAdressId() {
        return adressId;
    }
    
    public void setAdressId(int adressId){
        this.adressId = adressId;
    }
    
    
}
