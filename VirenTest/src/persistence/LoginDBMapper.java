/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import application.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Connection conn = DBConnectionPool.getConn();
        try{
            PreparedStatement read = conn.prepareStatement("select * from testpersonen where email=?");
            ResultSet rs = read.executeQuery();
            
            if(rs.next()){
                String dbEmail = rs.getString("email");
                String dbPwdHash = rs.getString("pwdhash");
                String dbSalt = rs.getString("salt");
                
            }else{
                return null;
            }
        }catch (SQLException exl){
            Logger.getLogger(VerwaltungJavaDBMapper.class.getName()).log(Level.SEVERE, null, exl);
        }finally{
            DBConnectionPool.deleteConn(conn);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
