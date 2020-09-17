/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author benni
 */
public class VirenTestcenterView extends JFrame{
    private JButton mitarbeiter;
    private JButton testperson;
    
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    private JLabel ueberschrift;
    
    
    
    public VirenTestcenterView(String titel) {
        super(titel);
        init();
    }
    
    private void init() {

        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virustestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(2,1));

        mitarbeiter = new JButton("Als Mitarbeiter einloggen");
        testperson = new JButton("Als Testperson einloggen");

        mitarbeiter.setFont(text);
        mitarbeiter.setBackground(background);
        testperson.setFont(text);
        testperson.setBackground(background);

        MitarbeiterButton mitarbeiterListener = new MitarbeiterButton();
        mitarbeiter.addActionListener(mitarbeiterListener);

        TestpersonButton testpersonListener = new TestpersonButton();
        testperson.addActionListener(testpersonListener);

        mitarbeiter.setFont(text);
        mitarbeiter.setBackground(background2);
        testperson.setFont(text);
        testperson.setBackground(background2);
        
        add(ueberschrift, BorderLayout.NORTH);
        panel.add(mitarbeiter);
        panel.add(testperson);
        add(panel, BorderLayout.CENTER);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        setBackground(background2);
        setLocation(650, 300);
        setVisible(true);

    }
    
    private class MitarbeiterButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new MitarbeiterLoginView("Mitarbeiter-Login");
        }        
    }
    
    private class TestpersonButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new TestpersonenLoginView("Testpersonen-Login");
        }        
    }
}
