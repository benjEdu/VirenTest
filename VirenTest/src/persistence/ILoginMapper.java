package persistence;

import application.Person;
import application.Testperson;


public interface ILoginMapper {
    public Testperson einloggen(String email, String pwd);
}
