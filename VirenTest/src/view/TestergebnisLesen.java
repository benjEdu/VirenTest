package view;

import application.TestpersonenVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.TestpersonJavaDBMapper;

public class TestergebnisLesen extends JFrame {

    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);

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

        //Überschrift
        ueberschrift = new JLabel("Willkommen bei Ihrem Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);

        //Label
        ausgabe = new JLabel("");
        ausgabe.setHorizontalAlignment(JLabel.CENTER);
        ausgabe.setFont(text);

        //zu Frame adden
        add(ueberschrift, BorderLayout.NORTH);
        add(ausgabe, BorderLayout.CENTER);

        //Ergebnis Abrufen
        TestpersonJavaDBMapper mapper = new TestpersonJavaDBMapper();
        boolean testPositiv = mapper.ergebnisAbrufen(testpersonId);
        //Angepasste Ausgabe an Ergebnis
        if (testPositiv) {
            ausgabe.setText("Das Ergebnis Ihres Tests ist positiv. Bitte begeben Sie sich für die kommenden zwei Wochen in Quarantäne.");
        } else {
            ausgabe.setText("Das Ergebnis Ihres Tests ist negativ.");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frameeinstellungen
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        setLocation(600, 300);
        setVisible(true);
    }
}
