/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import application.Login;
/**
 *
 * @author z003ub8r
 */

public class HashSaltTest {
    private static final String password = "ueberhauptnichtsicheresPasswort345";
    private static final String predefinedSalt = "ae62ef0054a04afc9f06aeede4341b30";
    private static final String correctHashedPassword = "116df06ac14f6d99256a5dfe602e388374d6628bc4893609e1c208fab865cc21dc1e28484600846921171abe3c7c9f6cf120e9f19de392a8070a48875ff20073";
    
    public static void main(String[] args){
        if(testSaltGeneration(predefinedSalt)){
            System.out.println("Generierung des Salts funktioniert :)");
        }else{
            System.out.println("Generierung des Salts funktioniert nicht :(");
            System.out.println("Dadurch funktioniert auch automatisch das Hashing nicht.");
        }
        if(testPasswordHashing(password, predefinedSalt, correctHashedPassword)){
            System.out.println("Hashing des Passworts funktioniert :)");
        }else{
            System.out.println("Hashing des Passworts funktioniert nicht :(");
        }
        
        
    }
    
    public static boolean testSaltGeneration(String predefinedSalt){
        String salt = Login.getSalt();
        System.out.println("Generated Salt: " + salt);
        if(salt.length()==32){
            if(salt.equals(predefinedSalt)){
                return false;
            }
            return true;
        }
        return false;
    }
    
    public static boolean testPasswordHashing(String password, String salt, String correctHashedPassword){
        String hashedPassword = Login.hashPassword(password, salt);
        System.out.println("Hashed Password: " + hashedPassword);
        if(hashedPassword.equals(correctHashedPassword)){
            return true;
        }
        return false;
    }
}
