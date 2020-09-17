package view;

 

import application.Mitarbeiter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 

public class MitarbeiterLesen extends JFrame {

    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);

    private JLabel ueberschrift;
    private JLabel vNameLabel;
    private JLabel nNameLabel;
    private JLabel emailLabel;
    private JLabel telLabel;
    private JLabel stadtLabel;
    private JLabel landLabel;
    private JLabel strasseLabel;
    private JLabel hnrLabel;
    private JLabel plzLabel;

 

    private JLabel vNameText;
    private JLabel nNameText;
    private JLabel emailText;
    private JLabel telText;
    private JLabel stadtText;
    private JLabel landText;
    private JLabel strasseText;
    private JLabel hnrText;
    private JLabel plzText;  

    private JButton zurueck;

 

    public MitarbeiterLesen(String titel, Mitarbeiter m) {
        super(titel);
        init(m);
    }

 

    private void init(Mitarbeiter m) {
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(10, 2));

 

        vNameLabel = new JLabel("Vorname");
        nNameLabel = new JLabel("Nachname");
        emailLabel = new JLabel("Email");
        telLabel = new JLabel("Telefonnummer");
        stadtLabel = new JLabel("Stadt");
        landLabel = new JLabel("Land");
        strasseLabel = new JLabel("Straße");
        hnrLabel = new JLabel("Hausnummer");
        plzLabel = new JLabel("Postleitzahl"); 

        vNameLabel.setFont(text);
        nNameLabel.setFont(text);
        emailLabel.setFont(text);
        telLabel.setFont(text);
        stadtLabel.setFont(text);
        landLabel.setFont(text);
        strasseLabel.setFont(text);
        hnrLabel.setFont(text);
        plzLabel.setFont(text);
 

        vNameText = new JLabel(m.getVname());
        nNameText = new JLabel(m.getNname());
        emailText = new JLabel(m.getEmail());
        telText = new JLabel(m.getTel());
        stadtText = new JLabel(m.getStadt());
        landText = new JLabel(m.getLand());
        strasseText = new JLabel(m.getStrasse());
        hnrText = new JLabel(m.getHsNr());
        plzText = new JLabel(m.getPlz());

 
        zurueck = new JButton("Zurück");
        MitarbeiterLesen.zurueckButtonListener zurückListener = new MitarbeiterLesen.zurueckButtonListener();
        zurueck.addActionListener(zurückListener);
        
        zurueck.setFont(text);
        zurueck.setBackground(background2);
        
        add(ueberschrift, BorderLayout.NORTH);
        panel.add(vNameLabel);
        panel.add(vNameText);
        panel.add(nNameLabel);
        panel.add(nNameText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(telLabel);
        panel.add(telText);
        panel.add(stadtLabel);
        panel.add(stadtText);
        panel.add(landLabel);
        panel.add(landText);
        panel.add(strasseLabel);
        panel.add(strasseText);
        panel.add(hnrLabel);
        panel.add(hnrText);
        panel.add(plzLabel);
        panel.add(plzText);
        add(panel, BorderLayout.CENTER);
        add(zurueck, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        this.getContentPane().setBackground(background);
        panel.setBackground(background);
        setLocation(550, 300);
        setVisible(true);
    }
    
    private class zurueckButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new MitarbeiterVerwaltungView("Verwaltung");
        }
    }

 

}
