package view;

import application.LaborantVerwaltung;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.LaborantJavaDBMapper;

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
        
        idLabel.setFont(text);
        ergebnisLabel.setFont(text);
        positiv.setFont(text);
        negativ.setFont(text);
        
        einfuegen.setBackground(background);
        einfuegen.setFont(text);

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
        add(einfuegen, BorderLayout.SOUTH);
        
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
            boolean ergebnis = lv.einfuegenTestergebnis(id, testPositiv);
            if(ergebnis){
                idText.setText("");
                negativ.isSelected();
            }
        }
    }
}