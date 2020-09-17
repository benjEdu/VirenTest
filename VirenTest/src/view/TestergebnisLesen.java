package view;

import application.TestpersonenVerwaltung;
import javax.swing.*;
import java.awt.*;
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

    private final TestpersonenVerwaltung tv;
    
    //Konstruktor
    public TestergebnisLesen(String titel, int id) {
        super(titel);
        tv = new TestpersonenVerwaltung();
        init(id);
    }

    private void init(int testpersonenId) {
        int testpersonId = testpersonenId;
        
        setLayout(new BorderLayout());

        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
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
        boolean testPositiv = tv.ergebnisAbrufen(testpersonId);
        //Angepasste Ausgabe an Ergebnis
        if (testPositiv) {
            ausgabe.setText("Das Ergebnis Ihres Tests ist positiv.");
        } else {
            ausgabe.setText("Das Ergebnis Ihres Tests ist negativ.");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frameeinstellungen
        setSize(800, 500);
        this.getContentPane().setBackground(background);
        setLocation(550, 300);
        setVisible(true);
    }
}
