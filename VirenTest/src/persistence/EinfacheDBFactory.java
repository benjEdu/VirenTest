/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author benni
 */
public class EinfacheDBFactory {
    public static ITestpersonMapper getTestpersonMapper(){
        return new TestpersonJavaDBMapper();
    }
    
    public static IAdminMapper getAdminMapper(){
        return new AdminJavaDBMapper();
    }
    
    public static IVerwaltungMapper getVerwaltungMapper(){
        return new VerwaltungJavaDBMapper();
    }
    
    public static ILaborantMapper getLaborantMapper(){
        return new LaborantJavaDBMapper();
    }
    
    public static ILoginMapper getLoginMapper(){
        return new LoginDBMapper();
    }
}
