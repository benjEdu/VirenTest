/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

public abstract class Person {
    private String nname;
    private String vname;
    private String email;
    private String tel;
    private String hsNr;
    private String strasse;
    private String stadt;
    private String plz;
    private String land;
    private String salt;
    private String pwdHash;
    private String pwd;

    
    //TODO Anzahl Personen reduzieren
    public Person() {
    }

    public Person(String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land, String salt, String pwdHash) {
        this.nname = nname;
        this.vname = vname;
        this.email = email;
        this.tel = tel;
        this.hsNr = hsNr;
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
        this.salt = salt;
        this.pwdHash = pwdHash;
    }

    public Person(String nname, String vname, String email, String tel, String salt, String pwdHash) {
        this.nname = nname;
        this.vname = vname;
        this.email = email;
        this.tel = tel;
        this.salt = salt;
        this.pwdHash = pwdHash;
    }
    
    public Person(String nname, String vname, String email, String tel) {
        this.nname = nname;
        this.vname = vname;
        this.email = email;
        this.tel = tel;
    }

    public Person(String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land, String pwd) {
        this.nname = nname;
        this.vname = vname;
        this.email = email;
        this.tel = tel;
        this.hsNr = hsNr;
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
        this.pwd = pwd;
    }
    
    public Person(String nname, String vname, String email, String tel, String hsNr, String strasse, String stadt, String plz, String land) {
        this.nname = nname;
        this.vname = vname;
        this.email = email;
        this.tel = tel;
        this.hsNr = hsNr;
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.land = land;
    }
    
    
    public String getSalt() {
        return salt;
    }

    public String getPwdHash() {
        return pwdHash;
    }
    
    public String getPwd(){
        return pwd;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHsNr() {
        return hsNr;
    }

    public void setHr(String hsNr) {
        this.hsNr = hsNr;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
    
    @Override
    public String toString(){
        vname = this.getVname();
        nname = this.getNname();
        tel = this.getTel();
        
        return "Vorname: "+ vname+"\nNachname: "+nname+"\nTelefonnummer: "+tel+"\n";
    }
}