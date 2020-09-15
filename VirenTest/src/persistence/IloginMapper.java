/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Person;

/**
 *
 * @author z003ub8r
 */
public interface IloginMapper {
    Person einloggen(String email, String pwd);
}
