/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

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
}
