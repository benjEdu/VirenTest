package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.VerwaltungJavaDBMapper;

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

    private String einfuegen;

    public TestpersonenVerwaltungView(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new GridLayout(4, 1));
        //idLabel = new JLabel("Person(ID):");
        //idText = new JTextField(10);
        eingabe = new JButton("Testperson hinzufügen");
        aendern = new JButton("Testperson ändern");
        loeschen = new JButton("Testperson löschen ");

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

        add(ueberschrift);
        add(eingabe);
        add(aendern);
        add(loeschen);

        TestpersonenVerwaltungView.MyActionListener listener = new TestpersonenVerwaltungView.MyActionListener();
        TestpersonenVerwaltungView.MyActionListener2 listener2 = new TestpersonenVerwaltungView.MyActionListener2();
        TestpersonenVerwaltungView.MyActionListener3 listener3 = new TestpersonenVerwaltungView.MyActionListener3();
        eingabe.addActionListener(listener);
        aendern.addActionListener(listener2);
        loeschen.addActionListener(listener3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(600, 400);
        this.getContentPane().setBackground(background);
        setLocation(600, 300);
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

        }
    }

    private class MyActionListener3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonLoeschen("Virentestcenter");
        }
    }
}
