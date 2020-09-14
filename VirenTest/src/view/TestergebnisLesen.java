package view;

import application.TestpersonenVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.TestpersonJavaDBMapper;

public class TestergebnisLesen extends JFrame {

    //Label

    private JLabel ausgabe;
    private JLabel ueberschrift;
    //Tesxtfelder

    //Buttons
 
    private final int testpersonId;

    //Konstruktor
    public TestergebnisLesen(String titel, int id) {
        super(titel);
        testpersonId = id;
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        //Label
        ausgabe = new JLabel("");
        ueberschrift = new JLabel("Willkommen bei Ihrem Virustestcenter");
        //zu Frame adden
        add(ueberschrift, BorderLayout.NORTH);
        add(ausgabe, BorderLayout.CENTER);
        
        //Ergebnis Abrufen
        TestpersonJavaDBMapper mapper = new TestpersonJavaDBMapper();
        boolean testPositiv = mapper.ergebnisAbrufen(testpersonId);
        //Angepasste Ausgabe an Ergebnis
        if (testPositiv) {
            ausgabe.setText("Das Ergebnis Ihres Tests ist positiv.  Bitte begeben Sie sich für die kommenden zwei Wochen in Quarantäne.");
        } else {
            ausgabe.setText("Das Ergebnis Ihres Tests ist negativ.");
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frameeinstellungen
        setSize(300, 200);
        setLocation(900, 200);
        setVisible(true);
    }
}
