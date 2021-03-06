package view;

import application.Admin;
import application.Laborant;
import application.LoginVerwaltung;
import application.Mitarbeiter;
import application.Verwaltung;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author z003ub8r
 */
public class MitarbeiterLoginView extends JFrame{
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    
    private JLabel emailLabel;
    private JLabel pwdLabel;
    private JLabel messageLabel;
    private JTextField emailText;
    private JPasswordField pwdField;
    private JButton login;
    private JButton zurueck;
    private JLabel ueberschrift;
    private LoginVerwaltung lv;

    
    public MitarbeiterLoginView(String titel){
        super(titel);
        lv = new LoginVerwaltung();
        init();
    }
    
    private void init(){
       setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(3,2));
        JPanel panel2 = new JPanel(new FlowLayout());
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(text);
        panel.add(emailLabel);
        
        pwdLabel = new JLabel("Passwort:");
        pwdLabel.setFont(text);
        panel.add(pwdLabel);

        emailText = new JTextField(30);
        panel.add(emailText);
        
        pwdField = new JPasswordField(60);
        panel.add(pwdField);
        
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.white);
        panel.add(messageLabel);
        
        login = new JButton("Login");
        zurueck = new JButton("Zurück");
        
        login.setFont(text);
        login.setBackground(background2);
        zurueck.setFont(text);
        zurueck.setBackground(background2);
        
        MyActionListener listener = new MyActionListener();
        login.addActionListener(listener);
        MyActionListener2 listener2 = new MyActionListener2();
        zurueck.addActionListener(listener2);
        panel2.add(zurueck);
        panel2.add(login);
        add(ueberschrift, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,250);
        this.getContentPane().setBackground(background);
        panel.setBackground(background2);
        panel2.setBackground(background);
        setLocation(550, 350);
        setVisible(true);
    }
    
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String email = emailText.getText();
            char[] charpwd = pwdField.getPassword();
            String pwd = "";
            for(char c : charpwd){
                pwd = pwd+c;
            }
            try{
                System.out.println(email);
                System.out.println(pwd);
                Mitarbeiter m = lv.mitarbeiterEinloggen(email, pwd);
                //Falls Email oder Passwort falsch sind wird eine NPE geworfen
                if(m==null){
                    System.out.println("Ist null");
                    throw new NullPointerException();
                }
                //Todo, je nach Rollenid auf unterschiedliche GUIs weiterleiten
                if(m instanceof Admin){
                    MitarbeiterVerwaltungView mvv = new MitarbeiterVerwaltungView("Mitarbeiterverwaltung");
                }else if(m instanceof Verwaltung){
                    TestpersonenVerwaltungView tvv = new TestpersonenVerwaltungView("Testpersonenverwaltung");
                }else if(m instanceof Laborant){
                    ViewLaborant vl = new ViewLaborant("Testergebnis ändern");
                }
                System.out.println("Erfolgreich eingeloggt.");
                setVisible(false);
                dispose();  
            }catch (NullPointerException ex){
                Logger.getLogger(TestpersonenLoginView.class.getName()).log(Level.FINE, null, ex);
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Email oder Passwort falsch!");
            }
        }
    }
    
    private class MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new VirenTestcenterView("Virentestcenter");
        }
    }
}
