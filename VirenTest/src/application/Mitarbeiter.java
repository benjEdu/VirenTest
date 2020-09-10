package application;


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
