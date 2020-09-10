package application;

import persistence.EinfacheDBFactory;
import persistence.ITestpersonMapper;

public class TestpersonenVerwaltung {
    private ITestpersonMapper mapper;
    
    public TestpersonenVerwaltung() {
        mapper = EinfacheDBFactory.getTestpersonMapper();
    }
}
