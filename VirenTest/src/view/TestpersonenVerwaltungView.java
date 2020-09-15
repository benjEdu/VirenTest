
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.VerwaltungJavaDBMapper;


public class TestpersonenVerwaltungView extends JFrame{
    //private JLabel idLabel;
    private JLabel eingabeLabel;
    private JLabel aendernLabel;
    private JLabel loeschenLabel;
    
    //private JTextField idText;
    
   private JButton eingabe; 
   private JButton aendern;
   private JButton loeschen;
   
   private String einfuegen;
    
    
    public TestpersonenVerwaltungView(String titel) {
        super(titel);
        init();
    }
    
    
    private void init() {
        setLayout(new GridLayout(3, 2));
        //idLabel = new JLabel("Person(ID):");
        //idText = new JTextField(10);
        eingabe = new JButton(" hinzufuegen");
        aendern = new JButton("eingabe aendern");
        loeschen = new JButton("eingabe loeschen ");
        
        add(eingabe);
        add(aendern);
        add(loeschen);
    
     TestpersonenVerwaltungView.MyActionListener listener = new TestpersonenVerwaltungView.MyActionListener();
     TestpersonenVerwaltungView.MyActionListener2 listener2 = new TestpersonenVerwaltungView.MyActionListener2();
     TestpersonenVerwaltungView.MyActionListener3 listener3 = new TestpersonenVerwaltungView.MyActionListener3();
        eingabe.addActionListener(listener);
        aendern.addActionListener(listener2);
        loeschen.addActionListener(listener3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        setSize(300, 200);
        setLocation(900, 200);
        setVisible(true);
    }
    
    private class MyActionListener implements ActionListener {
        private Object view;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            
            new TestpersonEinfuegen("Virentestcenter");
            

        }
    }
    
    private class MyActionListener2 implements ActionListener {
        private Object view;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            
            
            

        }
    }
    
    private class MyActionListener3 implements ActionListener {
        private Object view;

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            
            
            

        }
    }
}
