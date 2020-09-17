package view;

 

import application.Admin;
import application.AdminVerwaltung;
import application.Mitarbeiter;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

 

public class MitarbeiterLesen extends JFrame {

 

   // private AdminVerwaltung av;
    private JLabel vNameLabel;
    private JLabel nNameLabel;
    private JLabel emailLabel;
    private JLabel telLabel;
    private JLabel stadtLabel;
    private JLabel landLabel;
    private JLabel strasseLabel;
    private JLabel hnrLabel;
    private JLabel plzLabel;
    private JLabel bezeichnungLabel;
    private String idMit;

 

    private JLabel vNameText;
    private JLabel nNameText;
    private JLabel emailText;
    private JLabel telText;
    private JLabel stadtText;
    private JLabel landText;
    private JLabel strasseText;
    private JLabel hnrText;
    private JLabel plzText;  

    private JButton zurück;

 

    public MitarbeiterLesen(String titel, Mitarbeiter m) {
        super(titel);
        init(m);
    }

 

    private void init(Mitarbeiter m) {
        setLayout(new GridLayout(10, 2));

 

        vNameLabel = new JLabel("Vorname");
        nNameLabel = new JLabel("Nachname");
        emailLabel = new JLabel("Email");
        telLabel = new JLabel("Telefonnummer");
        stadtLabel = new JLabel("Stadt");
        landLabel = new JLabel("Land");
        strasseLabel = new JLabel("Straße");
        hnrLabel = new JLabel("Hausnummer");
        plzLabel = new JLabel("Postleitzahl");
        idMit = m.getMitarbeiterId();   

 

        vNameText = new JLabel(m.getVname());
        nNameText = new JLabel(m.getNname());
        emailText = new JLabel(m.getEmail());
        telText = new JLabel(m.getTel());
        stadtText = new JLabel(m.getStadt());
        landText = new JLabel(m.getLand());
        strasseText = new JLabel(m.getStrasse());
        hnrText = new JLabel(m.getHsNr());
        plzText = new JLabel(m.getPlz());

 
        zurück = new JButton("Zurück");
        MitarbeiterLesen.zurückButtonListener zurückListener = new MitarbeiterLesen.zurückButtonListener();
        zurück.addActionListener(zurückListener);
        
        
         
         add(vNameLabel);
         add(vNameText);
         add(nNameLabel);
         add(nNameText);
         add(emailLabel);
         add(emailText);
         add(telLabel);
         add(telText);
         add(stadtLabel);
         add(stadtText);
         add(landLabel);
         add(landText);
         add(strasseLabel);
         add(strasseText);
         add(hnrLabel);
         add(hnrText);
         add(plzLabel);
         add(plzText);
        add(zurück);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocation(550, 300);
        setVisible(true);
    }
    
    private class zurückButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new MitarbeiterVerwaltungView("Verwaltung");
        }
    }

 

}
