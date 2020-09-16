/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import persistence.EinfacheDBFactory;
import persistence.ILaborantMapper;

/**
 *
 * @author benni
 */
public class LaborantVerwaltung {
    private final ILaborantMapper mapper;
    
    public LaborantVerwaltung(){
        mapper = EinfacheDBFactory.getLaborantMapper();
    }
    
    public boolean einfuegenTestergebnis(String id, boolean ergebnis){
        return mapper.einfuegenTestergebnis(id, ergebnis);
    }
}
