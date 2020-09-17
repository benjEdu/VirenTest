package application;

import java.util.List;
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
    
     public String einfuegenTestperson(Testperson tp){
        return mapper.einfuegenTestperson(tp);
    }
    
    public String aendernTestperson(Testperson tp){
        return mapper.aendernTestperson(tp);
    }
    
    public boolean loeschenTestperson(int tpid){
        return mapper.loeschenTestperson(tpid);
    }
    
    Testperson lesenTestperson(int tpid){
        return mapper.lesenTestperson(tpid);
    }
    
    public List<Testperson> lesenAlleTestpersonen(){
        return mapper.lesenAlleTestpersonen();
    }
}
