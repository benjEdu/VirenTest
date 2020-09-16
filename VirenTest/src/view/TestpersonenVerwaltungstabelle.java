package view;

import application.Testperson;
import application.VerwaltungVerwaltung;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;


public class TestpersonenVerwaltungstabelle extends JFrame{
    
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    private VerwaltungVerwaltung vv;
    private JLabel ueberschrift;
    private JTable table;
    private JButton delete;
    private JLabel infoLabel;
    private JButton aendern;
    
    
    public TestpersonenVerwaltungstabelle(String titel){
        super(titel);
        vv = new VerwaltungVerwaltung();
        init();
    }
    
    private void init(){
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        String[] columnNames = {"Testpersonen-ID",
                        "Vorname",
                        "Nachname",
                        "E-Mail",
                        "Telefonnummer",
                        "Straße",
                        "Hausnummer",
                        "Postleitzahl",
                        "Stadt",
                        "Land",
                        "AdressId"
        };
        List<Testperson> data = vv.lesenAlleTestpersonen();
        Testperson[] data2 = data.toArray(new Testperson[0]);
        String[][] data3 = new String[data2.length][11];
        for(int i = 0; i < data.size(); i++){
            data3[i][0] = String.valueOf(data.get(i).getTestpersonId());
            data3[i][1] = data.get(i).getVname();
            data3[i][2] = data.get(i).getNname();
            data3[i][3] = data.get(i).getEmail();
            data3[i][4] = data.get(i).getTel();
            data3[i][5] = data.get(i).getStrasse();
            data3[i][6] = data.get(i).getHsNr();
            data3[i][7] = data.get(i).getPlz();
            data3[i][8] = data.get(i).getStadt();
            data3[i][9] = data.get(i).getLand();
            data3[i][10] = String.valueOf(data.get(i).getAdressId());
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
        setSize(900,800);
        this.getContentPane().setBackground(background);
        panel2.setBackground(background2);
        setLocation(400,400);
        setVisible(true);
        
    }
    
    private class DeleteButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer tpId = null;
                try{
                    tpId = Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0));
                    boolean ergebnis = vv.loeschenTestperson(tpId);
                    setVisible(false);
                    new TestpersonenVerwaltungstabelle("Virentestcenter");
                } catch (ArrayIndexOutOfBoundsException ex){
                    infoLabel.setText("Testperson auswählen");
                }
                
                
            }
        }
    
    private class AendernButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                String tpId = null;
                try{
                    tpId = (String)table.getValueAt(table.getSelectedRow(), 0);
                    Testperson tp = new Testperson(Integer.parseInt(tpId));
                    tp.setVname((String)table.getValueAt(table.getSelectedRow(), 1));
                    tp.setNname((String)table.getValueAt(table.getSelectedRow(), 2));
                    tp.setEmail((String)table.getValueAt(table.getSelectedRow(), 3));
                    tp.setTel((String)table.getValueAt(table.getSelectedRow(), 4));
                    tp.setStrasse((String)table.getValueAt(table.getSelectedRow(), 5));
                    tp.setHr((String)table.getValueAt(table.getSelectedRow(), 6));
                    tp.setPlz((String)table.getValueAt(table.getSelectedRow(), 7));
                    tp.setStadt((String)table.getValueAt(table.getSelectedRow(), 8));
                    tp.setLand((String)table.getValueAt(table.getSelectedRow(), 9));
                    tp.setAdressId(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 10)));
                    setVisible(false);
                    new TestpersonAendern("Virentestcenter", tp);
                } catch (ArrayIndexOutOfBoundsException ex){
                    infoLabel.setText("Testperson auswählen");
                }
                
            }
    }
    
}

