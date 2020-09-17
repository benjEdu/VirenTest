package view;

import application.LaborantVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewLaborant extends JFrame {
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    private final LaborantVerwaltung lv;
    
    //Label
    private JLabel ueberschrift;
    private JLabel idLabel;
    private JLabel ergebnisLabel;
    //Textfelder
    private JTextField idText;
    //Radiobutton
    private JRadioButton positiv;
    private JRadioButton negativ;
    //Button
    private JButton einfuegen;
    private JButton ausloggen;
    
    private boolean testPositiv;

    public ViewLaborant(String titel) {
        super(titel);
        lv = new LaborantVerwaltung();
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(2,2,0,10));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel3 = new JPanel(new FlowLayout());
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        //Label
        idLabel = new JLabel("Person(ID):");
        idText = new JTextField(10);
        ergebnisLabel = new JLabel("Testergebnis:");
        //RadioButton
        positiv = new JRadioButton("Test positiv", false);
        negativ = new JRadioButton("Test negativ", true);
        //Button
        einfuegen = new JButton("Einfügen");
        ausloggen = new JButton("Ausloggen");
        
        idLabel.setFont(text);
        ergebnisLabel.setFont(text);
        positiv.setFont(text);
        negativ.setFont(text);
        
        einfuegen.setBackground(background2);
        einfuegen.setFont(text);
        
        ausloggen.setFont(text);
        ausloggen.setBackground(background2);
        
        ausloggenActionListener ausloggenListener = new ausloggenActionListener();
        ausloggen.addActionListener(ausloggenListener);
        

        //Gruppierung RadioButton
        ButtonGroup ergebnisGroub = new ButtonGroup();
        ergebnisGroub.add(positiv);
        ergebnisGroub.add(negativ);

        //Zu Frame hinzufügen
        add(ueberschrift, BorderLayout.NORTH);
        panel.add(idLabel);
        panel.add(idText);
        panel.add(ergebnisLabel);
        panel2.add(positiv);
        panel2.add(negativ);
        panel.add(panel2);
        add(panel, BorderLayout.CENTER);
        panel3.add(ausloggen);
        panel3.add(einfuegen);
        add(panel3, BorderLayout.SOUTH);
        
        //Testergebnis negativ ausgewählt
        negativ.isSelected();

        ViewLaborant.MyActionListener listener = new ViewLaborant.MyActionListener();
        einfuegen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Eigenschaften Frame
        setSize(800, 500);
        this.getContentPane().setBackground(background);
        panel.setBackground(background2);
        panel2.setBackground(background2);
        panel3.setBackground(background);
        negativ.setBackground(background);
        positiv.setBackground(background);
        
        setLocation(550, 300);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String id = idText.getText();
            testPositiv = positiv.isSelected();
            boolean ergebnis = false;
            try {
                ergebnis = lv.einfuegenTestergebnis(id, testPositiv);
            } catch (SQLException ex) {
                try {
                    ergebnis = lv.aendernTestergebnis(id, testPositiv);
                } catch (SQLException ex1) {
                    System.out.println("Geht nicht");
                }
            }
            if(ergebnis){
                idText.setText("");
                negativ.isSelected();
            }
        }
    }
    
    private class ausloggenActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new VirenTestcenterView("Virentestcenter");
        }
    }
}