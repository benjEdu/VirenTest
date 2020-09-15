
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
    
    public boolean einfuegenMitarbeiter(Mitarbeiter m){
        return mapper.einfuegenMitarbeiter(m);
    }
            
    public boolean loeschenMitarbeiter(int id){
       return mapper.loeschenMitarbeiter(id);
    }
    
    public boolean aendernMitarbeiter(Mitarbeiter m){
        return mapper.aendernMitarbeiter(m);
    }
    
    public List<Mitarbeiter> lesenAlleMitarbeiter(){
        return mapper.lesenAlleMitarbeiter();
    }
    
    public Mitarbeiter lesenMitarbeiter(int id){
        return mapper.lesenMitarbeiter(id);
    }
            
}
