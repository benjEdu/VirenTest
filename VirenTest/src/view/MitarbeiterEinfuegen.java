package view;

import application.Admin;
import application.Laborant;
import application.Mitarbeiter;
import application.Testperson;
import application.Verwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.AdminJavaDBMapper;
import persistence.VerwaltungJavaDBMapper;

public class MitarbeiterEinfuegen extends JFrame {
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
    Boolean adminB;
    Boolean laborantB;
    Boolean verwaltungB;
    //Label
    private JLabel ueberschrift;
    private JLabel nname;
    private JLabel vname;
    private JLabel email; 
    private JLabel tel;
    private JLabel hsNr; 
    private JLabel strasse; 
    private JLabel stadt; 
    private JLabel plz; 
    private JLabel land;
    private JLabel rolle;
    //Tesxtfelder
    private JTextField nnameText;
    private JTextField vnameText;
    private JTextField emailText; 
    private JTextField telText;
    private JTextField hsNrText; 
    private JTextField strasseText; 
    private JTextField stadtText; 
    private JTextField plzText; 
    //Combobox
    private JComboBox land2;
    //RadioButton
    private JRadioButton admin;
    private JRadioButton laborant;
    private JRadioButton verwaltung;
    //Buttons
    private JButton einfuegen;
    
    //Konstruktor
    public MitarbeiterEinfuegen(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(11,2));
        
        JPanel panel2 = new JPanel(new GridLayout(1,3));
        
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virentestcenter");
        ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        ueberschrift.setFont(ueberschriftFont);
        
        //Label
        nname = new JLabel("Nachname:");
        nnameText = new JTextField(30);
        
        vname = new JLabel("Vorname:");
        vnameText = new JTextField(30);
        
        email = new JLabel("E-Mail:");
        emailText = new JTextField(60);
        
        tel = new JLabel("Telefonnummer:");
        telText = new JTextField(20);
        
        strasse = new JLabel("Straße:");
        strasseText = new JTextField(40);       
        
        hsNr = new JLabel("Hausnummer:");
        hsNrText = new JTextField(5);
        
        stadt = new JLabel("Stadt:");
        stadtText = new JTextField(5);
        
        plz = new JLabel("Postleitzahl:");
        plzText = new JTextField(6);
        
        land = new JLabel("Land:");
        
        rolle = new JLabel("RollenId:");
        
        //RadioButton
        admin = new JRadioButton("Admin", false);
        laborant = new JRadioButton("Laborant", false);
        verwaltung = new JRadioButton("Verwaltung", true);
        
        //Gruppierung RadioButton
        ButtonGroup ergebnisGroub = new ButtonGroup();
        ergebnisGroub.add(admin);
        ergebnisGroub.add(laborant);
        ergebnisGroub.add(verwaltung);
        
        nname.setFont(text);
        vname.setFont(text);
        email.setFont(text);
        tel.setFont(text);
        strasse.setFont(text);
        hsNr.setFont(text);
        stadt.setFont(text);
        plz.setFont(text);
        land.setFont(text);
        rolle.setFont(text);
        admin.setFont(text);
        laborant.setFont(text);
        verwaltung.setFont(text);

        
        //ComboBox
        String landArray[] = {"AD","AE",
                 "Afghanistan",
                 "Antigua und Barbuda",
                 "Anguilla",
                 "Albanien",
                 "Armenien",
                 "Niederländische Antillen",
                 "Angola",
                 "Antarktis",
                 "Argentinien",
                 "Amerikanisch-Samoa",
                 "Österreich (Austria)",
                 "Australien",
                 "Aruba",
                 "Azerbaijan",
                 "Bosnien-Herzegovina",
                 "Barbados",
                 "Bangladesh",
                 "Belgien",
                 "Burkina Faso",
                 "Bulgarien",
                 "Bahrain",
                 "Burundi",
                 "Benin",
                 "Bermudas",
                 "Brunei Darussalam",
                 "Bolivien",
                 "Brasilien",
                 "Bahamas",
                 "Bhutan",
                 "Bouvet Island",
                 "Botswana",
                 "Weißrußland (Belarus)",
                 "Belize",
                 "Canada",
                 "Cocos (Keeling) Islands",
                 "Demokratische Republik Kongo",
                 "Zentralafrikanische Republik",
                 "Kongo",
                 "Schweiz",
                 "Elfenbeinküste (Cote D'Ivoire)",
                 "Cook Islands",
                 "Chile",
                 "Kamerun",
                 "China",
                 "Kolumbien",
                 "Costa Rica",
                 "Tschechoslowakei (ehemalige)",
                 "Kuba",
                 "Kap Verde",
                 "Christmas Island",
                 "Zypern",
                 "Tschechische Republik",
                 "Deutschland",
                 "Djibouti",
                 "Dänemark",
                 "Dominica",
                 "Dominikanische Republik",
                 "Algerien",
                 "Ecuador",
                 "Estland",
                 "Ägypten",
                 "Westsahara",
                 "Eritrea",
                 "Spanien",
                 "Äthiopien",
                 "Finnland",
                 "Fiji",
                 "Falkland-Inseln (Malvinas)",
                 "Micronesien",
                 "Faröer-Inseln",
                 "Frankreich",
                 "France, Metropolitan",
                 "Gabon",
                 "Grenada",
                 "Georgien",
                 "Französisch Guiana",
                 "Ghana",
                 "Gibraltar",
                 "Grönland",
                 "Gambia",
                 "Guinea",
                 "Guadeloupe",
                 "Äquatorialguinea",
                 "Griechenland",
                 "Südgeorgien und Südliche Sandwich-Inseln",
                 "Guatemala",
                 "Guam",
                 "Guinea-Bissau",
                 "Guyana",
                 "Kong Hong",
                 "Heard und Mc Donald Islands",
                 "Honduras",
                 "Haiti",
                 "Ungarn",
                 "Indonesien",
                 "Irland",
                 "Israel",
                 "Indien",
                 "British Indian Ocean Territory",
                 "Irak",
                 "Iran (Islamische Republik)",
                 "Island",
                 "Italien",
                 "Jamaica",
                 "Jordanien",
                 "Japan",
                 "Kenya",
                 "Kirgisien",
                 "Königreich Kambodscha",
                 "Kiribati",
                 "Komoren",
                 "Saint Kitts und Nevis",
                 "Korea, Volksrepublik",
                 "Korea",
                 "Kuwait",
                 "Kayman Islands",
                 "Kasachstan",
                 "Laos",
                 "Libanon",
                 "Saint Lucia",
                 "Liechtenstein",
                 "Sri Lanka",
                 "Liberia",
                 "Lesotho",
                 "Littauen",
                 "Luxemburg",
                 "Lettland",
                 "Libyen",
                 "Marokko",
                 "Monaco",
                 "Moldavien",
                 "Madagaskar",
                 "Marshall-Inseln",
                 "Mazedonien, ehem. Jugoslawische Republik",
                 "Mali",
                 "Myanmar",
                 "Mongolei",
                 "Macao",
                 "Nördliche Marianneninseln",
                 "Martinique",
                 "Mauretanien",
                 "Montserrat",
                 "Malta",
                 "Mauritius",
                 "Malediven",
                 "Malawi",
                 "Mexico",
                 "Malaysien",
                 "Mozambique",
                 "Namibia",
                 "Neu Kaledonien",
                 "Niger",
                 "Norfolk Island",
                 "Nigeria",
                 "Nicaragua",
                 "Niederlande",
                 "Norwegen",
                 "Nepal",
                 "Nauru",
                 "Niue",
                 "Neuseeland",
                 "Oman",
                 "Panama",
                 "Peru",
                 "Französisch Polynesien",
                 "Papua Neuguinea",
                 "Philippinen",
                 "Pakistan",
                 "Polen",
                 "St. Pierre und Miquelon",
                 "Pitcairn",
                 "Puerto Rico",
                 "Portugal",
                 "Palau",
                 "Paraguay",
                 "Katar",
                 "Reunion",
                 "Rumänien",
                 "Russische Föderation",
                 "Ruanda",
                 "Saudi Arabien",
                 "Salomonen",
                 "Seychellen",
                 "Sudan",
                 "Schweden",
                 "Singapur",
                 "St. Helena",
                 "Slovenien",
                 "Svalbard und Jan Mayen Islands",
                 "Slowakei",
                 "Sierra Leone",
                 "San Marino",
                 "Senegal",
                 "Somalia",
                 "Surinam",
                 "Sao Tome und Principe",
                 "El Salvador",
                 "Syrien, Arabische Republik",
                 "Swaziland",
                 "Turk und Caicos-Inseln",
                 "Tschad",
                 "Französisches Südl.Territorium",
                 "Togo",
                 "Thailand",
                 "Tadschikistan",
                 "Tokelau",
                 "Turkmenistan",
                 "Tunesien",
                 "Tonga",
                 "Ost-Timor",
                 "Türkei",
                 "Trinidad und Tobago",
                 "Tuvalu",
                 "Taiwan",
                 "Tansania, United Republic of",
                 "Ukraine",
                 "Uganda",
                 "Großbritannien",
                 "Vereinigte Staaten",
                 "Vereinigte Staaten, Minor Outlying Islands",
                 "Uruguay",
                 "Usbekistan",
                 "Vatikanstaat",
                 "Saint Vincent und Grenadines",
                 "Venezuela",
                 "Virgin Islands (Britisch)",
                 "Virgin Islands (U.S.)",
                 "Vietnam",
                 "Vanuatu",
                 "Wallis und Futuna Islands",
                 "Samoa",
                 "Jemen",
                 "Mayotte",
                 "Jugoslawien",
                 "Südafrika",
                 "Sambia",
                 "Zimbabwe"
        };        
        land2 = new JComboBox(landArray);
        land2.setSelectedItem("Deutschland");
        //Button
        einfuegen = new JButton("Einfügen");
        //zu Frame adden
        
        panel.add(vname);
        panel.add(vnameText);
        panel.add(nname);
        panel.add(nnameText);
        panel.add(email);
        panel.add(emailText);
        panel.add(tel);
        panel.add(telText);
        panel.add(strasse);
        panel.add(strasseText);
        panel.add(hsNr);
        panel.add(hsNrText);
        panel.add(stadt);
        panel.add(stadtText);
        panel.add(plz);
        panel.add(plzText);
        panel.add(rolle);
        panel2.add(verwaltung);
        panel2.add(laborant);
        panel2.add(admin);
        panel.add(panel2);
        panel.add(land);
        panel.add(land2);
        
        add(ueberschrift, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(einfuegen, BorderLayout.SOUTH);
        
        
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        einfuegen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frameeinstellungen
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        panel.setBackground(background2);
        verwaltung.setBackground(background2);
        laborant.setBackground(background2);
        admin.setBackground(background2);
        setLocation(600, 300);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Eingabe von Nutzer
            String vname = vnameText.getText();
            String nname = nnameText.getText();
            String email = emailText.getText();
            String tel = telText.getText();
            String strasse = strasseText.getText();
            String hsNr = hsNrText.getText();
            String stadt = stadtText.getText();
            String plz = plzText.getText();
            adminB = admin.isSelected();
            laborantB = laborant.isSelected();
            verwaltungB = verwaltung.isSelected();
            String landAuswahl = land2.getSelectedItem() + "";
            
            Mitarbeiter m;
            AdminJavaDBMapper mapper = new AdminJavaDBMapper();
            
            if(adminB){
                m = new Admin("einfuegen");
            } else if(laborantB){
                m = new Laborant("einfuegen");
            } else{
                m = new Verwaltung("einfuegen");
            }

            m.setVname(vname);
            m.setNname(nname);
            m.setEmail(email);
            m.setTel(tel);
            m.setStrasse(strasse);
            m.setHr(hsNr);
            m.setStadt(stadt);
            m.setPlz(plz);
            m.setLand(landAuswahl);
            
            String ergebnis = mapper.einfuegenMitarbeiter(m);
            if(ergebnis.equals("Passt")){
                vnameText.setText("");
                nnameText.setText("");
                emailText.setText("");
                telText.setText("");
                strasseText.setText("");
                hsNrText.setText("");
                stadtText.setText("");
                plzText.setText("");
                verwaltung.isSelected();
                land2.setSelectedItem("Deutschland");
            }
        }        
    }
}
