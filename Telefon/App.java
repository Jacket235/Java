/**
 * @autor Sebastian Mastalerz
 * @version 1.0
 * @date 15.04.2024
 * @desc Aplikacja desktopowa "Ksiazka Telefoniczna".
 * */

package Telefon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;

public class App {
    Menu menu = new Menu(this);
    Dane dane = new Dane();
    ArrayList<Kontakt> osoby = dane.getKontakty();
    JPanel addContact;
    JPanel allContacts;
    public JPanel cntPane(){
        // addContact
        String[] days = new String[32];
        days[0] = "D";
        for(int d = 1;d <= 31; d++){
            days[d] = String.valueOf(d);
        }
        String[] months = new String[13];
        months[0] = "M";
        for(int m = 1;m <= 12; m++){
            months[m] = String.valueOf(m);
        }
        String[] years = new String[123];
        years[0] = "Y";
        for (int i = 1; i < years.length; i++) {
            years[i] = String.valueOf(Year.now().getValue() - (i - 1));
        }
        // showAllContacts
        String[] columnNames = {"Imie", "Nazwisko", "Telefon", "Data Urodzenia"};

        JPanel mainPanel = new JPanel(null);

        addContact = new JPanel(null);
        addContact.setBounds(0,0,288,616);
        addContact.setVisible(false);

        JLabel LImie = new JLabel("Imię:");
        LImie.setHorizontalAlignment(SwingConstants.CENTER);
        LImie.setFont(new Font("Arial", Font.PLAIN, 16));
        LImie.setBounds(20, 25, 110, 20);

        JLabel Lnazwisko = new JLabel("Nazwisko:");
        Lnazwisko.setHorizontalAlignment(SwingConstants.CENTER);
        Lnazwisko.setFont(new Font("Arial", Font.PLAIN, 16));
        Lnazwisko.setBounds(20, 65, 110, 20);

        JLabel Ltelefon = new JLabel("Telefon:");
        Ltelefon.setHorizontalAlignment(SwingConstants.CENTER);
        Ltelefon.setFont(new Font("Arial", Font.PLAIN, 16));
        Ltelefon.setBounds(20, 105, 110, 20);

        JLabel LdataUr = new JLabel("Data urodzenia:");
        LdataUr.setHorizontalAlignment(SwingConstants.CENTER);
        LdataUr.setFont(new Font("Arial", Font.PLAIN, 16));
        LdataUr.setBounds(20, 145, 110, 20);

        JTextField TFimie = new JTextField();
        TFimie.setBounds(135, 25, 133, 20);

        JTextField TFnazwisko = new JTextField();
        TFnazwisko.setBounds(135, 65, 133, 20);

        JTextField TFtelefon = new JTextField();
        TFtelefon.setBounds(135, 105, 133, 20);

        JComboBox TFdataUrDzien = new JComboBox(days);
        TFdataUrDzien.setBounds(135, 145, 46, 20);
        JComboBox TFdataUrMiesiac = new JComboBox(months);
        TFdataUrMiesiac.setBounds(182, 145, 46, 20);
        JComboBox TFdataUrRok = new JComboBox(years);
        TFdataUrRok.setBounds(227, 145, 46, 20);

        JButton BsubmitContact = new JButton("Dodaj Kontakt");
        BsubmitContact.setBounds(69, 220, 150, 25);
        BsubmitContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = TFimie.getText();
                String nazwisko = TFnazwisko.getText();
                String telefon = TFtelefon.getText();
                String dataUrDzien = String.valueOf(TFdataUrDzien.getSelectedItem());
                String dataUrMies = String.valueOf(TFdataUrMiesiac.getSelectedItem());
                String dataUrRok = String.valueOf(TFdataUrRok.getSelectedItem());

                dane.kontakty.add(new Kontakt(imie, nazwisko, telefon, dataUrDzien + "/" + dataUrMies + "/" + dataUrRok));
            }
        });

        allContacts = new JPanel(null);
        allContacts.setBounds(0,0,288,616);
        allContacts.setVisible(true);

//        JTable table = new JTable(data, columnNames);

        mainPanel.add(addContact);
        mainPanel.add(allContacts);

        addContact.add(LImie);
        addContact.add(Lnazwisko);
        addContact.add(Ltelefon);
        addContact.add(LdataUr);
        addContact.add(TFimie);
        addContact.add(TFnazwisko);
        addContact.add(TFtelefon);
        addContact.add(TFdataUrDzien);
        addContact.add(TFdataUrMiesiac);
        addContact.add(TFdataUrRok);
        addContact.add(BsubmitContact);
        return mainPanel;
    }
    public App(){
        menu = new Menu(this);
        dane.kontakty.add(new Kontakt());
        JFrame mainWndw = new JFrame("PESEL: Sebastian Mastalerz 4pp");

        mainWndw.setSize(288 , 616);
        mainWndw.setResizable(false);
        mainWndw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWndw.setContentPane(cntPane());
        mainWndw.setLocationRelativeTo(null);
        mainWndw.setJMenuBar(menu.getMenuBar());
        mainWndw.setVisible(true);
    }

    public void showAddContactPanel(){
        addContact.setVisible(true);
    }
    public void showAllContactsPanel(){
        allContacts.setVisible(true);
    }
    public void clearPanel(){
        addContact.setVisible(false);
    }
}