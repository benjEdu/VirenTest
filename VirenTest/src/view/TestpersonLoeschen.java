package view;

import application.TestpersonenVerwaltung;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.VerwaltungJavaDBMapper;

public class TestpersonLoeschen extends JFrame {
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    private final VerwaltungVerwaltung vv;
    
    //Label
    private JLabel ueberschrift;
    private JLabel id;
    
    //Tesxtfelder
    private JTextField idText;

    //Buttons
    private JButton loeschen;
    private JButton zurueck;
    
    //Konstruktor
    public TestpersonLoeschen(String titel) {
        super(titel);
        vv = new VerwaltungVerwaltung();
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(2,1));
        
        JPanel panel2 = new JPanel(new FlowLayout());
        
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        //Label
        id = new JLabel("Id der Testperson, die gelöscht werden soll:");
        idText = new JTextField(10);
        
        id.setFont(text);

        //Button
        loeschen = new JButton("Löschen");
        zurueck = new JButton("Zurück");
        
        loeschen.setFont(text);
        loeschen.setBackground(background2);
        zurueck.setFont(text);
        zurueck.setBackground(background2);
        
        //zu Frame adden
        
        panel.add(id);
        panel.add(idText);

        panel2.add(zurueck);
        panel2.add(loeschen);
        add(ueberschrift, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        
        
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        MyActionListener2 listener2 = new MyActionListener2();
        loeschen.addActionListener(listener);
        zurueck.addActionListener(listener2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frameeinstellungen
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        panel.setBackground(background2);
        panel2.setBackground(background);
        setLocation(600, 300);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            int id = Integer.parseInt(idText.getText());
         
            boolean ergebnis = vv.loeschenTestperson(id);
            if(ergebnis){
                idText.setText("");
            }
        }        
    }
    
    private class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonenVerwaltungView("Virentestcenter");
        }        
    }
}
