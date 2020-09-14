package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.LaborantJavaDBMapper;

public class ViewLaborant extends JFrame {

    //Label
    private JLabel idLabel;
    private JLabel ergebnissLabel;
    private JLabel infoLabel;
    private JLabel infoLabel2;
    //Textfelder
    private JTextField idText;
    //Combobox
    private JComboBox<String> ergebniss = new JComboBox<String>();
    //Radiobutton
    private JRadioButton positiv;
    private JRadioButton negativ;
    //Button
    private JButton einfuegen;
    
    private boolean testPositiv;

    public ViewLaborant(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new GridLayout(3, 2));
        //Label
        idLabel = new JLabel("Person(ID):");
        idText = new JTextField(10);
        ergebnissLabel = new JLabel("Testergebnis");
        infoLabel = new JLabel("");
        //RadioButton
        positiv = new JRadioButton("Test positiv", false);
        negativ = new JRadioButton("Test negativ", true);
        //Button
        einfuegen = new JButton("insert");

        //Gruppierung RadioButton
        ButtonGroup ergebnisGroub = new ButtonGroup();
        ergebnisGroub.add(positiv);
        ergebnisGroub.add(negativ);

        //Zu Frame hinzufügen
        add(idLabel);
        add(idText);
        add(ergebnissLabel);
        add(positiv);
        add(negativ);
        add(einfuegen);
        add(infoLabel);
        //Testergebnis negativ ausgewählt
        negativ.isSelected();

        ViewLaborant.MyActionListener listener = new ViewLaborant.MyActionListener();
        einfuegen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Eigenschaften Frame
        setSize(300, 200);
        setLocation(900, 200);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String id = idText.getText();
            LaborantJavaDBMapper mapper = new LaborantJavaDBMapper();
            testPositiv = positiv.isSelected();
            boolean ergebnis = mapper.einfuegenTestergebnis(id, testPositiv);
            infoLabel.setText(ergebnis + "");
            if(ergebnis){
                idText.setText("");
                negativ.isSelected();
            }
        }
    }
}