package persistence;

import application.Person;


public interface ILoginMapper {
    public Person einloggen(String email, String pwd);
}