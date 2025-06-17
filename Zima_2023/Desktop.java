package Zima_2023;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.ArrayList;

public class Desktop {

    public JPanel contentPane(){
        String[] stanowiska = {"", "Kierownik", "Starszy programista", "Młodszy programista", "Tester"};
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.decode("#B0C4DE"));

        JPanel danePanel = new JPanel(null);
        danePanel.setBackground(Color.decode("#B0C4DE"));
        danePanel.setSize(280, 200);
        danePanel.setLocation(20, 20);
        danePanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.white, 5, true), "Dane pracownika"));

        JLabel lblImie = new JLabel("Imię");
        lblImie.setSize(110, 25);
        lblImie.setLocation(25, 30);

        JLabel lblNazwisko = new JLabel("Nazwisko");
        lblNazwisko.setSize(110, 25);
        lblNazwisko.setLocation(25, 65);

        JLabel lblStanowisko = new JLabel("Stanowisko");
        lblStanowisko.setSize(110, 25);
        lblStanowisko.setLocation(25, 100);

        JTextField tfImie = new JTextField();
        tfImie.setSize(110, 25);
        tfImie.setLocation(145, 30);

        JTextField tfNazwisko = new JTextField();
        tfNazwisko.setSize(110, 25);
        tfNazwisko.setLocation(145, 65);

        JComboBox<String> cbStanowisko = new JComboBox<>(stanowiska);
        cbStanowisko.setSize(110, 25);
        cbStanowisko.setLocation(145, 100);

        JPanel generatorPanel = new JPanel(null);
        generatorPanel.setBackground(Color.decode("#B0C4DE"));
        generatorPanel.setSize(280, 200);
        generatorPanel.setLocation(380, 20);
        generatorPanel.setBorder(new LineBorder(Color.white, 5, true));
        generatorPanel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.white, 5, true), "Generowanie hasła"));

        JLabel lblIloscZnakow = new JLabel("Ile znaków?");
        lblIloscZnakow.setSize(110, 25);
        lblIloscZnakow.setLocation(25, 30);

        JTextField tfIloscZnakow = new JTextField();
        tfIloscZnakow.setSize(110, 25);
        tfIloscZnakow.setLocation(145, 30);

        JCheckBox cbMaleWielkieZnaki = new JCheckBox("Małe i wielkie litery");
        cbMaleWielkieZnaki.setSelected(true);
        cbMaleWielkieZnaki.setBackground(Color.decode("#B0C4DE"));
        cbMaleWielkieZnaki.setSize(240, 25);
        cbMaleWielkieZnaki.setLocation(25, 65);

        JCheckBox cbCyfry = new JCheckBox("Cyfry");
        cbCyfry.setBackground(Color.decode("#B0C4DE"));
        cbCyfry.setSize(240, 25);
        cbCyfry.setLocation(25, 100);

        JCheckBox cbZnakiSpecjalne = new JCheckBox("Znaki specjalne");
        cbZnakiSpecjalne.setBackground(Color.decode("#B0C4DE"));
        cbZnakiSpecjalne.setSize(240, 25);
        cbZnakiSpecjalne.setLocation(25, 135);

        JButton bGenerujHaslo = new JButton("Generuj hasło");
        bGenerujHaslo.setBorder(new LineBorder(Color.white, 2, true));
        bGenerujHaslo.setBackground(Color.decode("#4682B4"));
        bGenerujHaslo.setForeground(Color.white);
        bGenerujHaslo.setSize(120, 20);
        bGenerujHaslo.setLocation(80, 165);

        StringBuilder haslo = new StringBuilder();

        Character[] maleLitery = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Character[] duzeLitery = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', };
        Character[] cyfry = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Character[] znakiSpecjalne = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '='};

        bGenerujHaslo.addActionListener(e -> {
            if(tfIloscZnakow.getText().isEmpty()) return;

            ArrayList<Character[]> znakiDoHasla = new ArrayList<>();

            int liczbaZnakow = Integer.parseInt(tfIloscZnakow.getText());
            boolean czyLitery = cbMaleWielkieZnaki.isSelected();
            boolean czyCyfry = cbCyfry.isSelected();
            boolean czySpecjalne = cbZnakiSpecjalne.isSelected();

            if(czyLitery){
                znakiDoHasla.add(maleLitery);
                znakiDoHasla.add(duzeLitery);
            }
            if(czyCyfry){
                znakiDoHasla.add(cyfry);
            }
            if(czySpecjalne){
                znakiDoHasla.add(znakiSpecjalne);
            }
            if(!czyLitery && !czyCyfry && !czySpecjalne) return;

            for(int i = 0; i < liczbaZnakow; i++){
                int losowaTablica = (int) (Math.random() * znakiDoHasla.size());
                int losowyZnak = (int) (Math.random() * znakiDoHasla.get(losowaTablica).length);
                haslo.append(znakiDoHasla.get(losowaTablica)[losowyZnak]);
            }
            JOptionPane.showMessageDialog(null, haslo, "", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton bZatwierdz = new JButton("Zatwierdź");
        bZatwierdz.setBorder(new LineBorder(Color.white, 2, true));
        bZatwierdz.setBackground(Color.decode("#4682B4"));
        bZatwierdz.setForeground(Color.white);
        bZatwierdz.setSize(180, 25);
        bZatwierdz.setLocation(260, 230);

        bZatwierdz.addActionListener(e -> {
            String imie = tfImie.getText();
            String nazwisko = tfImie.getText();
            String stanowisko = String.valueOf(cbStanowisko.getSelectedItem());
            if(haslo.isEmpty() || imie.isEmpty() || nazwisko.isEmpty() || stanowisko.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Wprowadź wszystkie dane i wygeneruj hasło!", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(null, "Dane pracownika: " + imie + " " + nazwisko + " " + stanowisko + " Hasło: " + haslo, "", JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(bZatwierdz);

        mainPanel.add(danePanel);
        danePanel.add(lblImie);
        danePanel.add(tfImie);
        danePanel.add(lblNazwisko);
        danePanel.add(tfNazwisko);
        danePanel.add(lblStanowisko);
        danePanel.add(cbStanowisko);

        mainPanel.add(generatorPanel);
        generatorPanel.add(lblIloscZnakow);
        generatorPanel.add(tfIloscZnakow);
        generatorPanel.add(cbMaleWielkieZnaki);
        generatorPanel.add(cbCyfry);
        generatorPanel.add(cbZnakiSpecjalne);
        generatorPanel.add(bGenerujHaslo);

        return mainPanel;
    }
    public Desktop(){
        JFrame okno = new JFrame("Dodaj pracownika 00000000000");
        okno.setSize(700, 300);
        okno.setLocationRelativeTo(null);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.setContentPane(contentPane());
        okno.setVisible(true);
    }

    public static void main(String[] args) {
        new Desktop();
    }
}
