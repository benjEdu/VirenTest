/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.AdminVerwaltung;
import application.Mitarbeiter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        
        setLayout(new FlowLayout());

        mitarbeiter = new JButton("Mitarbeiter");
        testperson = new JButton("Testperson");

        mitarbeiter.setFont(text);
        mitarbeiter.setBackground(background);
        testperson.setFont(text);
        testperson.setBackground(background);

        MitarbeiterButton mitarbeiterListener = new MitarbeiterButton();
        mitarbeiter.addActionListener(mitarbeiterListener);

        TestpersonButton testpersonListener = new TestpersonButton();
        testperson.addActionListener(testpersonListener);

        add(ueberschrift, BorderLayout.NORTH);
        add(mitarbeiter);
        add(testperson);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        this.getContentPane().setBackground(background);
        setBackground(background2);
        setLocation(550, 300);
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
