package view;

import application.Testperson;
import application.VerwaltungVerwaltung;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import persistence.TestpersonJavaDBMapper;
import persistence.VerwaltungJavaDBMapper;

public class TestpersonEinfuegen extends JFrame {
    //Hintergrundfarbe
    Color background = new Color(229, 255, 249);
    Color background2 = new Color(194, 255, 241);
    //Schriftart und -größe
    Font ueberschriftFont = new Font("SansSerif", Font.BOLD, 25);
    Font text = new Font("SansSerif", Font.BOLD, 17);
    
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
    private JLabel infoLabel;
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
    //Buttons
    private JButton einfuegen;
    
    //Konstruktor
    public TestpersonEinfuegen(String titel) {
        super(titel);
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        
        JPanel blub = new JPanel(new GridLayout(9,2));
        
        
        //Überschrift
        ueberschrift = new JLabel("Willkommen beim Virustestcenter");
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
        
        infoLabel = new JLabel("");
        
        nname.setFont(text);
        vname.setFont(text);
        email.setFont(text);
        tel.setFont(text);
        strasse.setFont(text);
        hsNr.setFont(text);
        stadt.setFont(text);
        plz.setFont(text);
        land.setFont(text);

        
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
        einfuegen = new JButton("insert");
        //zu Frame adden
        
        blub.add(vname);
        blub.add(vnameText);
        blub.add(nname);
        blub.add(nnameText);
        blub.add(email);
        blub.add(emailText);
        blub.add(tel);
        blub.add(telText);
        blub.add(strasse);
        blub.add(strasseText);
        blub.add(hsNr);
        blub.add(hsNrText);
        blub.add(stadt);
        blub.add(stadtText);
        blub.add(plz);
        blub.add(plzText);
        blub.add(land);
        blub.add(land2);
        
        add(ueberschrift, BorderLayout.NORTH);
        add(blub, BorderLayout.CENTER);
        add(einfuegen, BorderLayout.SOUTH);
        
        
        //ActionListener für Button
        MyActionListener listener = new MyActionListener();
        einfuegen.addActionListener(listener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frameeinstellungen
        setSize(600, 400);
        this.getContentPane().setBackground(background);
        blub.setBackground(background2);
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
            String landAuswahl = land2.getSelectedItem() + "";
            
            
            VerwaltungJavaDBMapper mapper = new VerwaltungJavaDBMapper();
            
            Testperson te = new Testperson(nname, vname, email, tel, hsNr, strasse, stadt, plz, landAuswahl);
            
            String ergebnis = mapper.einfuegenTestperson(te);
            if(ergebnis.equals("Testperson erfolgreich eingefügt :)")){
                vnameText.setText("");
                nnameText.setText("");
                emailText.setText("");
                telText.setText("");
                strasseText.setText("");
                hsNrText.setText("");
                stadtText.setText("");
                plzText.setText("");
                land2.setSelectedItem("Deutschland");
            }
            infoLabel.setText(ergebnis + "");
        }        
    }
}
