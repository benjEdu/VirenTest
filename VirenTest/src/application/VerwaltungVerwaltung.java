/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import persistence.EinfacheDBFactory;
import persistence.IVerwaltungMapper;

/**
 *
 * @author benni
 */
public class VerwaltungVerwaltung {
    private final IVerwaltungMapper mapper;
    
    public VerwaltungVerwaltung(){
        mapper = EinfacheDBFactory.getVerwaltungMapper();
    }
}
