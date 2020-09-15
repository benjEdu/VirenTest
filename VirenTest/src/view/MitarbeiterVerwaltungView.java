
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private AdminVerwaltung av;
    private JTable table;
    
    
    public MitarbeiterVerwaltungView(String titel){
        super(titel);
        av = new AdminVerwaltung();
        init();
    }
    
    private void init(){
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
        
        setLayout(new GridLayout(1,1));
        table = new JTable(data3, columnNames);
        add(table);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocation(400,400);
        setVisible(true);
    }
    
}

