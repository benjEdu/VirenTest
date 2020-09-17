package view;

import application.Admin;
import application.Laborant;
import application.LoginVerwaltung;
import application.Mitarbeiter;
import application.Person;
import application.Testperson;
import application.Verwaltung;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author z003ub8r
 */
public class MitarbeiterLoginView extends JFrame{
    private JLabel emailLabel;
    private JLabel pwdLabel;
    private JLabel messageLabel;
    private JTextField emailText;
    private JPasswordField pwdField;
    private JButton login;
    private LoginVerwaltung lv;

    
    public MitarbeiterLoginView(String titel){
        super(titel);
        lv = new LoginVerwaltung();
        init();
    }
    
    private void init(){
        setLayout(new GridLayout(3,2));
        
        emailLabel = new JLabel("Email:");
        add(emailLabel);
        
        pwdLabel = new JLabel("Passwort:");
        add(pwdLabel);

        emailText = new JTextField(30);
        add(emailText);
        
        pwdField = new JPasswordField(60);
        add(pwdField);
        
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.white);
        add(messageLabel);
        
        login = new JButton("Login");
        MyActionListener listener = new MyActionListener();
        login.addActionListener(listener);
        add(login);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,200);
        setLocation(900,200);
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
}
