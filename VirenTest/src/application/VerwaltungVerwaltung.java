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
