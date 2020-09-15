package view;

import application.AdminVerwaltung;
import application.Mitarbeiter;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author benni
 */
public class MitarbeiterVerwaltungView extends JFrame{
    
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    private JLabel ueberschrift;
    private AdminVerwaltung av;
    private JTable table;
    
    
    
    public MitarbeiterVerwaltungView(String titel){
        super(titel);
        av = new AdminVerwaltung();
        init();
    }
    
    private void init(){
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        String[] columnNames = {"Mitarbeiter-ID",
                        "Vorname",
                        "Nachname",
                        "E-Mail",
                        "Telefonnummer",
                        "Straße",
                        "Hausnummer",
                        "Postleitzahl",
                        "Stadt",
                        "Land"
        };
        List<Mitarbeiter> data = av.lesenAlleMitarbeiter();
        Mitarbeiter[] data2 = data.toArray(new Mitarbeiter[0]);
        String[][] data3 = new String[data2.length][10];
        for(int i = 0; i < data.size(); i++){
            data3[i][0] = data.get(i).getMitarbeiterId();
            data3[i][1] = data.get(i).getVname();
            data3[i][2] = data.get(i).getNname();
            data3[i][3] = data.get(i).getEmail();
            data3[i][4] = data.get(i).getTel();
            data3[i][5] = data.get(i).getStrasse();
            data3[i][6] = data.get(i).getHsNr();
            data3[i][7] = data.get(i).getPlz();
            data3[i][8] = data.get(i).getStadt();
            data3[i][9] = data.get(i).getLand();
        }
        
        setLayout(new BorderLayout());
        table = new JTable(data3, columnNames);
        table.setFont(text);
        table.setBackground(background2);
        add(ueberschrift, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,500);
        this.getContentPane().setBackground(background);
        setLocation(550,300);
        setVisible(true);
    }
    
}

