/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Person;
import application.Testperson;


public interface ILoginMapper {
    public Testperson einloggen(String email, String pwd);
}


