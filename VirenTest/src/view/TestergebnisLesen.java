package view;

import application.TestpersonenVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.TestpersonJavaDBMapper;

public class TestergebnisLesen extends JFrame {
    //Label
    private JLabel idLabel;
    private JLabel infoLabel;
    //Tesxtfelder
    private JTextField idText;
    //Buttons
    private JButton lesen;
    
    //Konstruktor
    public TestergebnisLesen(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new GridLayout(3, 2));
        //Label
        idLabel = new JLabel("Zu lesende Person (ID):");
        idText = new JTextField(10);
        infoLabel = new JLabel("");
        //Button
        lesen = new JButton("read");
        //zu Frame adden
        add(idLabel);
        add(idText);
        add(lesen);
        add(infoLabel);
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        lesen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frameeinstellungen
        setSize(300, 200);
        setLocation(900, 200);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String id = idText.getText();
            TestpersonJavaDBMapper mapper = new TestpersonJavaDBMapper();
            boolean ergebnis = mapper.ergebnisAbrufen(id);
            infoLabel.setText(ergebnis + "");
        }        
    }
}
