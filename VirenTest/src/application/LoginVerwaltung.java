/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import persistence.LoginDBMapper;

/**
 *
 * @author z003ub8r
 */
public class LoginVerwaltung {
    private final ILoginMapper mapper;
    
    public PersonenVerwaltung(){
        mapper = LoginDBMapper();
        
    }
    
    public boolean einfuegenPerson(Person p){
        return mapper.einfuegenPerson(p);
    }
}
