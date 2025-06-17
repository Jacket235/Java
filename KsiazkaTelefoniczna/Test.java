package KsiazkaTelefoniczna;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Test {

    public static Properties loadProperties() throws IOException {
        InputStream input = new FileInputStream("dane.properties");
        Properties ustawienia = new Properties();
        ustawienia.load(input);

        return ustawienia;
    }

    public void testConnection() throws IOException {
        Connection connection = null;

        Properties ustawienia = loadProperties();

        try{
            connection = DriverManager.getConnection(ustawienia.getProperty("url") + ustawienia.getProperty("base"), ustawienia.getProperty("user"), ustawienia.getProperty("password"));
            JOptionPane.showMessageDialog(
                    null,
                    "Połączenie udane",
                    "Sukces",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch(SQLException exec){
            JOptionPane.showMessageDialog(
                    null,
                    "Połączenie nie powiodło się",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) throws IOException {
        Test as = new Test();
        as.testConnection();
    }
}