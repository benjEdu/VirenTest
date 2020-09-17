package persistence;

import application.Mitarbeiter;
import application.Person;
import application.Testperson;


public interface ILoginMapper {
    public Testperson testpersonEinloggen(String email, String pwd);
    public Mitarbeiter mitarbeiterEinloggen(String email, String pwd);
}
