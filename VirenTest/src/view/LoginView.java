/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import application.LoginVerwaltung;
import application.Person;
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
import persistence.VerwaltungJavaDBMapper;
import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author z003ub8r
 */
public class LoginView extends JFrame{
    private JLabel emailLabel;
    private JLabel pwdLabel;
    private JLabel messageLabel;
    private JTextField emailText;
    private JPasswordField pwdField;
    private JButton login;
    private LoginVerwaltung lv;

    
    public LoginView(String titel){
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
        
        messageLabel = new JLabel();
        messageLabel.setForeground(Color.white);
        add(messageLabel);
        
        emailText = new JTextField(30);
        add(emailText);
        
        pwdField = new JPasswordField(60);
        add(pwdField);
        
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
                Person p = lv.einloggen(email, pwd);
            }catch (NullPointerException ex){
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setBackground(Color.red);
                messageLabel.setText("Email oder Passwort falsch!");
            }
            System.out.println("Erfolgreich eingefügt.");
        }
    }
}