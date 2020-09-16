
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Mitarbeiter;
import java.util.List;

/**
 *
 * @author benni
 */
public interface IAdminMapper {
    public String einfuegenMitarbeiter (Mitarbeiter m);
    
    public String aendernMitarbeiter (Mitarbeiter m);
    
    public boolean loeschenMitarbeiter (int id);
    
    Mitarbeiter lesenMitarbeiter (int id);
    
    List<Mitarbeiter> lesenAlleMitarbeiter ();
}
