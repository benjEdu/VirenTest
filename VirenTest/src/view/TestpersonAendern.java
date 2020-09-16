package view;

import application.Testperson;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestpersonAendern extends JFrame {

    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    private JLabel ueberschrift;

    private VerwaltungVerwaltung vv;

    
    private JLabel vNameLabel;
    private JLabel nNameLabel;
    private JLabel emailLabel;
    private JLabel telLabel;
    private JLabel stadtLabel;
    private JLabel landLabel;
    private JLabel strasseLabel;
    private JLabel hnrLabel;
    private JLabel plzLabel;
    private int idTp;

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
    
    private Testperson testperson;

    public TestpersonAendern(String titel, Testperson tp) {
        super(titel);
        vv = new VerwaltungVerwaltung();
        init(tp);
    }

    private void init(Testperson tp) {

        testperson = tp;
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
        idTp = tp.getTestpersonId();

        vNameText = new JTextField(tp.getVname());
        nNameText = new JTextField(tp.getNname());
        emailText = new JTextField(tp.getEmail());
        telText = new JTextField(tp.getTel());
        stadtText = new JTextField(tp.getStadt());
        landText = new JTextField(tp.getLand());
        strasseText = new JTextField(tp.getStrasse());
        hnrText = new JTextField(tp.getHsNr());
        plzText = new JTextField(tp.getPlz());

        
        vNameLabel.setFont(text);
        nNameLabel.setFont(text);
        emailLabel.setFont(text);
        telLabel.setFont(text);
        stadtLabel.setFont(text);
        landLabel.setFont(text);
        strasseLabel.setFont(text);
        hnrLabel.setFont(text);
        plzLabel.setFont(text);
        
                
        setLayout(new BorderLayout());
        
        JPanel panel2 = new JPanel(new GridLayout(9, 2));
        
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
        setSize(900, 800);
        this.getContentPane().setBackground(background);
        panel2.setBackground(background2);
        panel3.setBackground(background2);
        setLocation(400, 400);
        setVisible(true);

    }

    private class AendernButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Testperson tp = new Testperson(idTp);
            if (vNameText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                tp.setVname(vNameText.getText());
                if (emailText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                    tp.setEmail(emailText.getText());
                    if (telText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                        tp.setTel(telText.getText());
                        if (stadtText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                            tp.setStadt(stadtText.getText());
                            if (landText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                tp.setLand(landText.getText());
                                if (strasseText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                    tp.setStrasse(strasseText.getText());
                                    if (hnrText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                        tp.setHr(hnrText.getText());
                                        if (plzText.getText().trim() != null && !vNameText.getText().trim().isEmpty()) {
                                            tp.setPlz(plzText.getText());
                                            if (nNameText.getText().trim() != null && !nNameText.getText().trim().isEmpty()) {
                                                tp.setNname(nNameText.getText());
                                                vv.aendernTestperson(tp);
                                                setVisible(false);
                                                new TestpersonenVerwaltungstabelle("Virentestcenter");
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
            new TestpersonenVerwaltungstabelle("Virentestcenter");
        }
    }
}
