package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestpersonenVerwaltungView extends JFrame {

    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);

    private JLabel eingabeLabel;
    private JLabel aendernLabel;
    private JLabel loeschenLabel;
    private JLabel ueberschrift;
    
    private JButton eingabe;
    private JButton aendern;
    private JButton loeschen;
    private JButton ausloggen;

    private String einfuegen;

    public TestpersonenVerwaltungView(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        eingabe = new JButton("Testperson hinzufügen");
        aendern = new JButton("Testperson ändern");
        loeschen = new JButton("Testperson löschen ");
        ausloggen = new JButton("Ausloggen");
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);

        eingabe.setFont(text);
        eingabe.setBackground(background2);
        aendern.setFont(text);
        aendern.setBackground(background);
        loeschen.setFont(text);
        loeschen.setBackground(background2);
        ausloggen.setFont(text);
        ausloggen.setBackground(background);

        add(ueberschrift, BorderLayout.NORTH);
        panel.add(eingabe);
        panel.add(aendern);
        panel.add(loeschen);
        add(panel, BorderLayout.CENTER);
        add(ausloggen, BorderLayout.SOUTH);

        TestpersonenVerwaltungView.MyActionListener listener = new TestpersonenVerwaltungView.MyActionListener();
        TestpersonenVerwaltungView.MyActionListener2 listener2 = new TestpersonenVerwaltungView.MyActionListener2();
        TestpersonenVerwaltungView.MyActionListener3 listener3 = new TestpersonenVerwaltungView.MyActionListener3();
        ausloggenActionListener ausloggenListener = new ausloggenActionListener();
        ausloggen.addActionListener(ausloggenListener);
        eingabe.addActionListener(listener);
        aendern.addActionListener(listener2);
        loeschen.addActionListener(listener3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 400);
        this.getContentPane().setBackground(background);
        panel.setBackground(background);
        setLocation(650, 300);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonEinfuegen("Virentestcenter");
        }
    }

    private class MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonenVerwaltungstabelle("Virentestcenter");
        }
    }

    private class MyActionListener3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonLoeschen("Virentestcenter");
        }
    }
    
    private class ausloggenActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new VirenTestcenterView("Virentestcenter");
        }
    }
}
