package KsiazkaTelefoniczna;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Read {

    private static JTextArea TAFullContactList;

    public Read(JTextArea TAFullContactList){
        this.TAFullContactList = TAFullContactList;
    }

    public static void readData() {
        String QUERYSelect = "SELECT * FROM kontakt";
        Properties ustawienia = null;
        Connection conn = null;

        try {
            ustawienia = Test.loadProperties();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ładowanie informacji o bazie danych nie powiodło się!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        try {
            conn = DriverManager.getConnection(ustawienia.getProperty("url") + ustawienia.getProperty("base"), ustawienia.getProperty("user"), ustawienia.getProperty("password"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Połączenie nie powiodło się!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(QUERYSelect);
            if (!result.isBeforeFirst()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Nie udało się nam znaleźć takiej osoby, przepraszamy!",
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                while (result.next()) {
                    TAFullContactList.append("ID: " + result.getInt("id") + "\n" +
                            "Imię: " + result.getString("imie") + "\n" +
                            "Nazwisko: " + result.getString("nazwisko") + "\n" +
                            "Telefon: " + result.getInt("telefon") + "\n" +
                            "Opis: " + result.getString("opis") + "\n \n");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Coś poszło nie tak",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
        } catch (NullPointerException ignored) {
            // Handle null pointer exception
        }
    }
}
