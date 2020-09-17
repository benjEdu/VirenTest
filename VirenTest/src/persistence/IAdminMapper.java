
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import application.Mitarbeiter;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author benni
 */
public interface IAdminMapper {
    public String einfuegenMitarbeiter (Mitarbeiter m) throws SQLException;
    
    public String aendernMitarbeiter (Mitarbeiter m) throws SQLException;
    
    public boolean loeschenMitarbeiter (int id) throws SQLException;
    
    Mitarbeiter lesenMitarbeiter (int id) throws SQLException;
    
    List<Mitarbeiter> lesenAlleMitarbeiter () throws SQLException;
}
