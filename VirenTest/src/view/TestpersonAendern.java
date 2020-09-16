package view;


import application.Testperson;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TestpersonAendern extends JFrame{
    
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    private JLabel ueberschrift;
    
    private final VerwaltungVerwaltung vv;
    
    private JLabel vNameLabel;
    private JLabel nNameLabel;
    private JLabel emailLabel;
    private JLabel telLabel;
    private JLabel stadtLabel;
    private JLabel landLabel;
    private JLabel strasseLabel;
    private JLabel hnrLabel;
    private JLabel plzLabel;
    
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
    
    private Testperson te2;
    
    public TestpersonAendern(String titel, Testperson te){
        super(titel);
        vv = new VerwaltungVerwaltung();
        init(te);
    }
    
    private void init(Testperson te){
        
        te2 = te;
        
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
        
        vNameText = new JTextField(te.getVname());
        nNameText = new JTextField(te.getNname());
        emailText = new JTextField(te.getEmail());
        telText = new JTextField(te.getTel());
        stadtText = new JTextField(te.getStadt());
        landText = new JTextField(te.getLand());
        strasseText = new JTextField(te.getStrasse());
        hnrText = new JTextField(te.getHsNr());
        plzText = new JTextField(te.getPlz());
        
        setLayout(new GridLayout(10, 2));
        
        aendern = new JButton("Ändern");
        AendernButtonListener aendernListener = new AendernButtonListener();
        aendern.addActionListener(aendernListener);
        
        add(ueberschrift);
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
                    
                    
                    if(!vNameText.getText().isEmpty() && !vNameText.getText().equals("")){
                        
                        te2.setVname(vNameText.getText());
                    }
                    if(!nNameText.getText().isEmpty() && !nNameText.getText().equals("")){
                        te2.setNname(nNameText.getText());
                    }
                    if(!emailText.getText().isEmpty() && !emailText.getText().equals("")){
                        te2.setEmail(emailText.getText());
                    }
                    if(!telText.getText().isEmpty() && !telText.getText().equals("")){
                        te2.setTel(telText.getText());
                    }
                    if(!stadtText.getText().isEmpty() && !stadtText.getText().equals("")){
                        te2.setStadt(stadtText.getText());
                    }
                    if(!landText.getText().isEmpty() && !landText.getText().equals("")){
                        te2.setLand(landText.getText());
                    }
                    if(!strasseText.getText().isEmpty() && !strasseText.getText().equals("")){
                        te2.setStrasse(strasseText.getText());
                    }
                    if(!hnrText.getText().isEmpty() && !hnrText.getText().equals("")){
                        te2.setHr(hnrText.getText());
                    }
                    if(!plzText.getText().isEmpty() && !plzText.getText().equals("")){
                        te2.setPlz(plzText.getText());
                    }
                    System.out.println(te2.getVname());
                    vv.aendernTestperson(te2);
                    
                    setVisible(false);
                    new TestpersonenVerwaltungView("Verwaltung");
                
                
            }
    }
}
