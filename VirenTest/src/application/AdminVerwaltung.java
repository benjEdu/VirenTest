
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.sql.SQLException;
import java.util.List;
import persistence.EinfacheDBFactory;
import persistence.IAdminMapper;

/**
 *
 * @author benni
 */
public class AdminVerwaltung {
    private final IAdminMapper mapper;
    
    public AdminVerwaltung(){
        mapper = EinfacheDBFactory.getAdminMapper();
    }
    
    public String einfuegenMitarbeiter(Mitarbeiter m) throws SQLException{
        return mapper.einfuegenMitarbeiter(m);
    }
            
    public boolean loeschenMitarbeiter(int id) throws SQLException{
       return mapper.loeschenMitarbeiter(id);
    }
    
    public String aendernMitarbeiter(Mitarbeiter m) throws SQLException{
        return mapper.aendernMitarbeiter(m);
    }
    
    public List<Mitarbeiter> lesenAlleMitarbeiter() throws SQLException{
        return mapper.lesenAlleMitarbeiter();
    }
    
    public Mitarbeiter lesenMitarbeiter(int id) throws SQLException{
        return mapper.lesenMitarbeiter(id);
    }
            
}
