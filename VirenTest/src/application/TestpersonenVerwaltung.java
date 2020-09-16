package application;

import java.util.List;
import persistence.EinfacheDBFactory;
import persistence.ITestpersonMapper;

public class TestpersonenVerwaltung {
    private ITestpersonMapper mapper;
    
    public TestpersonenVerwaltung() {
        mapper = EinfacheDBFactory.getTestpersonMapper();
    }
    public boolean ergebnisAbrufen(int testpersonId){
        return mapper.ergebnisAbrufen(testpersonId);
    }
    
}