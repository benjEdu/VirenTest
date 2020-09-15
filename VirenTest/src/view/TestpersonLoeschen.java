package view;

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
    
    //Label
    private JLabel ueberschrift;
    private JLabel id;
    
    //Tesxtfelder
    private JTextField idText;

    //Buttons
    private JButton loeschen;
    
    //Konstruktor
    public TestpersonLoeschen(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(2,1));
        
        
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
        //zu Frame adden
        
        panel.add(id);
        panel.add(idText);

        
        add(ueberschrift, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(loeschen, BorderLayout.SOUTH);
        
        
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        loeschen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frameeinstellungen
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        panel.setBackground(background2);
        setLocation(600, 300);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            int id = Integer.parseInt(idText.getText());
            VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();

            boolean ergebnis = mapper.loeschenTestperson(id);
            if(ergebnis){
                idText.setText("");
            }
        }        
    }
}
