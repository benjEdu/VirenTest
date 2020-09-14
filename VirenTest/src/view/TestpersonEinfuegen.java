package view;

import application.Testperson;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.TestpersonJavaDBMapper;
import persistence.VerwaltungJavaDBMapper;

public class TestpersonEinfuegen extends JFrame {
    //Labels
    
    private JLabel nname;
    private JLabel vname;
    private JLabel email; 
    private JLabel tel;
    private JLabel hsNr; 
    private JLabel strasse; 
    private JLabel stadt; 
    private JLabel plz; 
    private JLabel land;
    
    private JLabel infoLabel;
    //Tesxtfelder
    private JTextField nnameText;
    private JTextField vnameText;
    private JTextField emailText; 
    private JTextField telText;
    private JTextField hsNrText; 
    private JTextField strasseText; 
    private JTextField stadtText; 
    private JTextField plzText; 
    private JTextField landText;
    //Buttons
    private JButton einfuegen;
    
    //Konstruktor
    public TestpersonEinfuegen(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new GridLayout(3, 2));
        //Label
        nname = new JLabel("Nachname:");
        nnameText = new JTextField(30);
        
        vname = new JLabel("Vorname:");
        vnameText = new JTextField(30);
        
        email = new JLabel("E-Mail:");
        emailText = new JTextField(60);
        
        tel = new JLabel("Telefonnummer:");
        telText = new JTextField(20);
        
        strasse = new JLabel("Straße:");
        strasseText = new JTextField(40);       
        
        hsNr = new JLabel("Hausnummer:");
        hsNrText = new JTextField(5);
        
        stadt = new JLabel("Stadt:");
        stadtText = new JTextField(5);
        
        plz = new JLabel("Postleitzahl:");
        plzText = new JTextField(6);
        
        land = new JLabel("Land:");
        landText = new JTextField(20);
        
        infoLabel = new JLabel("");
        
        //Button
        einfuegen = new JButton("insert");
        //zu Frame adden
        add(vname);
        add(vnameText);
        add(nname);
        add(nnameText);
        add(strasse);
        add(strasseText);
        add(hsNr);
        add(hsNrText);
        add(stadt);
        add(stadtText);
        add(plz);
        add(plzText);
        add(land);
        add(landText);
       
        add(einfuegen);
        add(infoLabel);
        
        
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        einfuegen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frameeinstellungen
        setSize(600, 400);
        setLocation(900, 200);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String vname = vnameText.getText();
            String nname = nnameText.getText();
            String email = emailText.getText();
            String tel = telText.getText();
            String strasse = strasseText.getText();
            String hsNr = hsNrText.getText();
            String stadt = stadtText.getText();
            String plz = plzText.getText();
            String land = landText.getText();
            
            
            VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
            
            Testperson te = new Testperson(nname, vname, email, tel, hsNr, strasse, stadt, plz, land);
            
            boolean ergebnis = mapper.einfuegenTestperson(te);
            
            infoLabel.setText(ergebnis + "");
        }        
    }
}
