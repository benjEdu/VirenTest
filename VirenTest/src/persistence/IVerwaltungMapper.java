/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Testperson;
import java.util.List;

/**
 *
 * @author benni
 */
public interface IVerwaltungMapper {
    public String einfuegenTestperson(Testperson p);
    
    public String aendernTestperson(Testperson p);
    
    public boolean loeschenTestperson(int id);
    
    Testperson lesenTestperson(int id);
    
    List<Testperson> lesenAlleTestpersonen();
}
