/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.LaborantJavaDBMapper;


public class ViewLaborant extends JFrame{
    
    private JLabel idLabel;
    private JLabel ergebnissLabel;
    private JLabel infoLabel;
    private JLabel infoLabel2;
 
    private JTextField idText;
    private JTextField ergebnissText;

    private JComboBox <String> ergebniss = new JComboBox<String>();
    
    private JButton lesen;
    
        
    public ViewLaborant(String titel) {
        super(titel);
        init();
    }
    
    private JRadioButton positiv;
    private JRadioButton negativ;
    private boolean testPositiv;
    
    private void init() {
        setLayout(new GridLayout(4, 2));
        
        idLabel = new JLabel("Zu lesende Person (ID):");
        idText = new JTextField(10);
        ergebnissLabel = new JLabel("Testergebniss eintragen (ergebniss)");   
        
        infoLabel = new JLabel("");
        infoLabel2 = new JLabel("");
        
        lesen = new JButton("read");

        positiv = new JRadioButton("Test positiv", false);
        negativ = new JRadioButton("Test negativ", true);
        
        ButtonGroup ergebnisGroub = new ButtonGroup();
        ergebnisGroub.add(positiv);
        ergebnisGroub.add(negativ);
        
        add(idLabel);
        add(ergebnissLabel);
        add(idText);
        
        add(lesen);
        add(infoLabel);
        add(infoLabel2);
        
        add(positiv);
        add(negativ);
        
        ViewLaborant.MyActionListener listener = new ViewLaborant.MyActionListener();
        lesen.addActionListener(listener);
        positiv.addActionListener(listener);
        negativ.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(300, 200);
        setLocation(900, 200);
        setVisible(true);
    }
    
     private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String id = idText.getText() ;
            
            LaborantJavaDBMapper mapper = new LaborantJavaDBMapper();
            
           
            boolean ergebnis = mapper.einfuegenTestergebnis(id, testPositiv);
            
            infoLabel.setText(ergebniss + "");
        }        
    }
     
          private class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            
            testPositiv = positiv.isSelected();
            infoLabel2.setText(testPositiv + "");
            
        
        
        }}
}


