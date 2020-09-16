



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.Admin;
import application.AdminVerwaltung;
import application.Laborant;
import application.Mitarbeiter;
import application.Verwaltung;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;


public class MitarbeiterVerwaltungView extends JFrame{
    
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    private AdminVerwaltung av;
    private JLabel ueberschrift;
    private JTable table;
    private JButton delete;
    private JLabel infoLabel;
    private JButton aendern;
    
    
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
                        "Land",
                        "Bezeichnunug"
        };
        List<Mitarbeiter> data = av.lesenAlleMitarbeiter();
        Mitarbeiter[] data2 = data.toArray(new Mitarbeiter[0]);
        String[][] data3 = new String[data2.length][11];
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
            String bezeichnung = data.get(i).getClass().getSimpleName();
            data3[i][10] = bezeichnung;
        }
        
        setLayout(new BorderLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        
        table = new JTable(data3, columnNames){
            @Override
            public boolean isCellEditable(int x, int y) {
                return false;
            }
        };
        table.setCellSelectionEnabled(false);
        
        delete = new JButton("Löschen");
        DeleteButtonListener deleteListener = new DeleteButtonListener();
        delete.addActionListener(deleteListener);
        
        infoLabel = new JLabel();
        
        aendern = new JButton("Ändern");
        AendernButtonListener aendernListener = new AendernButtonListener();
        aendern.addActionListener(aendernListener);
        
        aendern.setFont(text);
        aendern.setBackground(background);
        delete.setFont(text);
        delete.setBackground(background);
        
        table.setFont(text);
        table.setBackground(background2);
        add(ueberschrift, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        panel2.add(delete);
        panel2.add(aendern);
        panel2.add(infoLabel);
        add(panel2, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 500);
        this.getContentPane().setBackground(background);
        panel2.setBackground(background2);
        setLocation(400,300);
        setVisible(true);
        
    }
    
    private class DeleteButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer mId = null;
                try{
                    mId = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
                    boolean ergebnis = av.loeschenMitarbeiter(mId);
                    setVisible(false);
                    new MitarbeiterVerwaltungView("Verwaltung");
                } catch (ArrayIndexOutOfBoundsException ex){
                    infoLabel.setText("Mitarbeiter auswählen");
                }
                
                
            }
        }
    
    private class AendernButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                String mId = null;
                String bezeichnung = null;
                try{
                    Mitarbeiter m = null;
                    mId = (String)table.getValueAt(table.getSelectedRow(), 0);
                    bezeichnung = (String)table.getValueAt(table.getSelectedRow(), 10);
                    switch (bezeichnung) {
                        case "Admin":
                            m = new Admin(mId);
                            break;
                        case "Verwaltung":
                            m = new Verwaltung(mId);
                            break;
                        case "Laborant":
                            m = new Laborant(mId);
                            break;
                        default:
                            infoLabel.setText("Mitarbeiter nicht gefunden");
                    }
                    m.setVname((String)table.getValueAt(table.getSelectedRow(), 1));
                    m.setNname((String)table.getValueAt(table.getSelectedRow(), 2));
                    m.setEmail((String)table.getValueAt(table.getSelectedRow(), 3));
                    m.setTel((String)table.getValueAt(table.getSelectedRow(), 4));
                    m.setStrasse((String)table.getValueAt(table.getSelectedRow(), 5));
                    m.setHr((String)table.getValueAt(table.getSelectedRow(), 6));
                    m.setPlz((String)table.getValueAt(table.getSelectedRow(), 7));
                    m.setStadt((String)table.getValueAt(table.getSelectedRow(), 8));
                    m.setLand((String)table.getValueAt(table.getSelectedRow(), 9));
                    setVisible(false);
                    new MitarbeiterAendernView("Mitarbeiter ändern", m);
                } catch (ArrayIndexOutOfBoundsException ex){
                    infoLabel.setText("Mitarbeiter auswählen");
                }
                
            }
    }
    
}

