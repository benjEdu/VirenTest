/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import persistence.EinfacheDBFactory;
import persistence.LoginDBMapper;
import persistence.ILoginMapper;
/**
 *
 * @author z003ub8r
 */
public class LoginVerwaltung {
    private final ILoginMapper mapper;
    
    public LoginVerwaltung(){
        mapper = EinfacheDBFactory.getLoginMapper();
        
    }
    
    public Testperson testpersonEinloggen(String email, String pwd){
        return mapper.testpersonEinloggen(email, pwd);
    }
    
    public Mitarbeiter mitarbeiterEinloggen(String email, String pwd){
        return mapper.mitarbeiterEinloggen(email, pwd);
    }
}
