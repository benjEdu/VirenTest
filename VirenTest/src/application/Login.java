package application;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/**
 *
 * @author z003ub8r
 */
public class Login {
    private static final String pepper = "fjdasiopfjdisaopjfifdsaf4dhallowerauchimmerdasliestsa89f48s9daf45dsaf4dsa89f4ds8a9dospajfoipas";
	
    /*Insgesamt wird der Hash iterationen-mal wiederholt gehasht. Hierdurch erhoeht sich die Komplexitaet
    Eigentlich sollte der Wert um einiges groesser als 5 sein, aber fuer dieses Studiumsprojekt reicht das locker
    Den Wert von Iterationen nicht aendern, sonst koennen sich bestehende Nutzer nicht mehr einloggen!!!*/
    private static final int iterationen = 5; //!!ACHTUNG!!

    //Hashfunktion initial aufrufen und bei 0ter Iteration beginnen
    public static String hashPassword(String passwordToHash, String salt) {
            //Die 0 nicht aendern, sonst koennen sich bestehende Nutzer nicht mehr einloggen!!!
            return hashPassword(passwordToHash, salt, 0); //!!ACHTUNG!!
    }

    public static String hashPassword(String passwordToHash, String salt, int iteration){
            passwordToHash += pepper;
        String generatedPassword = null;
        try {
            //Passwort in Kombination mit salt und pepper mittels SHA-512 Algorithmus hashen
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(iteration<iterationen) {
            iteration++;
            //Die Komplexitaet weiter erhoehen
            if(iteration % 2 == 0) {
                    generatedPassword = hashPassword(generatedPassword, salt, iteration);
            }else {
                    generatedPassword = hashPassword(generatedPassword, pepper, iteration);
            }	
        }
        return generatedPassword;
    }
}