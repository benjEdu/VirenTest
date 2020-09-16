/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import application.Person;
import persistence.DBConnectionPool;

/**
 *
 * @author z003ub8r
 */
public class LoginDBMapper implements ILoginMapper{

    public LoginDBMapper(){
        
    }

    @Override
    public Person einloggen(String email, String pwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
