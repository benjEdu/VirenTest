package view;

import application.Admin;
import application.AdminVerwaltung;
import application.Laborant;
import application.Mitarbeiter;
import application.Verwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class MitarbeiterAendernView extends JFrame {

    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    private JLabel ueberschrift;

    private final AdminVerwaltung av;

    private JLabel rolleLabel;
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
    private JButton zurueck;

    public MitarbeiterAendernView(String titel, Mitarbeiter m) {
        super(titel);
        av = new AdminVerwaltung();
        init(m);
    }

    private void init(Mitarbeiter m) {

        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virustestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);

        rolleLabel = new JLabel("Rolle");
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

        rolleLabel.setFont(text);
        vNameLabel.setFont(text);
        nNameLabel.setFont(text);
        emailLabel.setFont(text);
        telLabel.setFont(text);
        stadtLabel.setFont(text);
        landLabel.setFont(text);
        strasseLabel.setFont(text);
        hnrLabel.setFont(text);
        plzLabel.setFont(text);
        bezeichnungLabel.setFont(text);
        
                
        setLayout(new BorderLayout());
        
        JPanel panel2 = new JPanel(new GridLayout(10, 2));
        
        JPanel panel3 = new JPanel(new FlowLayout());

        aendern = new JButton("Ändern");
        zurueck = new JButton("Zurück");

        aendern.setFont(text);
        aendern.setBackground(background);
        zurueck.setFont(text);
        zurueck.setBackground(background);

        AendernButtonListener aendernListener = new AendernButtonListener();
        aendern.addActionListener(aendernListener);

        MyActionListener2 listener2 = new MyActionListener2();
        zurueck.addActionListener(listener2);

        add(ueberschrift, BorderLayout.NORTH);
        panel2.add(rolleLabel);
        panel2.add(bezeichnungLabel);
        panel2.add(vNameLabel);
        panel2.add(vNameText);
        panel2.add(nNameLabel);
        panel2.add(nNameText);
        panel2.add(emailLabel);
        panel2.add(emailText);
        panel2.add(telLabel);
        panel2.add(telText);
        panel2.add(stadtLabel);
        panel2.add(stadtText);
        panel2.add(landLabel);
        panel2.add(landText);
        panel2.add(strasseLabel);
        panel2.add(strasseText);
        panel2.add(hnrLabel);
        panel2.add(hnrText);
        panel2.add(plzLabel);
        panel2.add(plzText);
        panel3.add(zurueck);
        panel3.add(aendern);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        this.getContentPane().setBackground(background);
        panel2.setBackground(background2);
        panel3.setBackground(background2);
        setLocation(550, 300);
        setVisible(true);

    }

    private class AendernButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Mitarbeiter mit = null;
            switch (bezeichnungLabel.getText()) {
                case "Admin":
                    mit = new Admin(idMit);
                    break;
                case "Verwaltung":
                    mit = new Verwaltung(idMit);
                    break;
                case "Laborant":
                    mit = new Laborant(idMit);
                    break;
                default:
                    break;
            }

            if (vNameText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                mit.setVname(vNameText.getText());
                if (emailText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                    mit.setEmail(emailText.getText());
                    if (telText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                        mit.setTel(telText.getText());
                        if (stadtText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                            mit.setStadt(stadtText.getText());
                            if (landText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                mit.setLand(landText.getText());
                                if (strasseText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                    mit.setStrasse(strasseText.getText());
                                    if (hnrText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                        mit.setHr(hnrText.getText());
                                        if (plzText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                            mit.setPlz(plzText.getText());
                                            if (nNameText.getText().trim() != null && !nNameText.getText().trim().isEmpty()) {
                                                mit.setNname(nNameText.getText());
                                                try {
                                                    av.aendernMitarbeiter(mit);
                                                } catch (SQLException ex) {
                                                    System.out.println(ex.toString());
                                                }
                                                setVisible(false);
                                                new MitarbeiterVerwaltungView("Verwaltung");
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private class MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new MitarbeiterVerwaltungView("Virentestcenter");
        }
    }
}
