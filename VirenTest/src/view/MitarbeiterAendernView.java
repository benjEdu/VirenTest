/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import application.Admin;
import application.AdminVerwaltung;
import application.Laborant;
import application.Mitarbeiter;
import application.Verwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MitarbeiterAendernView extends JFrame{
    
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    private JLabel ueberschrift;
    
    private AdminVerwaltung av;
    
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
    
    private JTextField vNameText;
    private JTextField nNameText;
    private JTextField emailText;
    private JTextField telText;
    private JTextField stadtText;
    private JTextField landText;
    private JTextField strasseText;
    private JTextField hnrText;
    private JTextField plzText;
    
    private JButton aendern;
    
    public MitarbeiterAendernView(String titel, Mitarbeiter m){
        super(titel);
        av = new AdminVerwaltung();
        init(m);
    }
    
    private void init(Mitarbeiter m){
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virustestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        vNameLabel = new JLabel("Vorname");
        nNameLabel = new JLabel("Nachname");
        emailLabel = new JLabel("Email");
        telLabel = new JLabel("Telefonnummer");
        stadtLabel = new JLabel("Stadt");
        landLabel = new JLabel("Land");
        strasseLabel = new JLabel("Straße");
        hnrLabel = new JLabel("Hausnummer");
        plzLabel = new JLabel("Postleitzahl");
        bezeichnungLabel = new JLabel(m.getClass().getSimpleName());
        idMit = m.getMitarbeiterId();
        
        vNameText = new JTextField(m.getVname());
        nNameText = new JTextField(m.getNname());
        emailText = new JTextField(m.getEmail());
        telText = new JTextField(m.getTel());
        stadtText = new JTextField(m.getStadt());
        landText = new JTextField(m.getLand());
        strasseText = new JTextField(m.getStrasse());
        hnrText = new JTextField(m.getHsNr());
        plzText = new JTextField(m.getPlz());
        
        setLayout(new GridLayout(10,2));
        
        aendern = new JButton("Ändern");
        AendernButtonListener aendernListener = new AendernButtonListener();
        aendern.addActionListener(aendernListener);
        
        add(ueberschrift);
        add(bezeichnungLabel);
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
        add(aendern);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,800);
        this.getContentPane().setBackground(background);
        setLocation(400,400);
        setVisible(true);
        
    }
    
    private class AendernButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    Mitarbeiter m = null;
                    switch (bezeichnungLabel.getText()) {
                        case "Admin":
                            m = new Admin(idMit);
                            break;
                        case "Verwaltung":
                            m = new Verwaltung(idMit);
                            break;
                        case "Laborant":
                            m = new Laborant(idMit);
                            break;
                        default:
                            break;
                    }
                    if(!vNameText.getText().isEmpty() && !vNameText.getText().equals("")){
                        
                        m.setVname(vNameText.getText());
                    }
                    if(!nNameText.getText().isEmpty() && !nNameText.getText().equals("")){
                        m.setNname(nNameText.getText());
                    }
                    if(!emailText.getText().isEmpty() && !emailText.getText().equals("")){
                        m.setEmail(emailText.getText());
                    }
                    if(!telText.getText().isEmpty() && !telText.getText().equals("")){
                        m.setTel(telText.getText());
                    }
                    if(!stadtText.getText().isEmpty() && !stadtText.getText().equals("")){
                        m.setStadt(stadtText.getText());
                    }
                    if(!landText.getText().isEmpty() && !landText.getText().equals("")){
                        m.setLand(landText.getText());
                    }
                    if(!strasseText.getText().isEmpty() && !strasseText.getText().equals("")){
                        m.setStrasse(strasseText.getText());
                    }
                    if(!hnrText.getText().isEmpty() && !hnrText.getText().equals("")){
                        m.setHr(hnrText.getText());
                    }
                    if(!plzText.getText().isEmpty() && !plzText.getText().equals("")){
                        m.setPlz(plzText.getText());
                    }
                    
                    av.aendernMitarbeiter(m);
                    
                    setVisible(false);
                    new MitarbeiterVerwaltungView("Verwaltung");
                
                
            }
    }
}
