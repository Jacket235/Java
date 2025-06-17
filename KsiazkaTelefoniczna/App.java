/**
 * @author Sebastian Mastalerz
 * @version 1.0
 * @date 05.12.2023
 * Aplikacja książka telefoniczna, łącząca się z bazą SQL i mająca funkcje takie jak
 * testowanie połączenia z bazą, wczytywanie pliku bazy z rozszerzeniem .sql, wyświetlenie
 * pełnej listy kontaktów i wyszukiwanie osoby za pomocą jej nazwiska.
 * */

package KsiazkaTelefoniczna;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class App extends Component implements ActionListener {
    JFrame mainWindow;
    JTextArea TAInfo;
    JTextArea TAFullContactList;
    JDialog searchDialog;
    public JPanel myCntPane(){
        JPanel mainPnl = new JPanel(null);

        TAFullContactList = new JTextArea();
        TAFullContactList.setLineWrap(true);
        TAFullContactList.setEditable(false);

        JScrollPane testScrollPane = new JScrollPane(TAFullContactList);
        testScrollPane.setBounds(0,0, 348, 440); // x-12,y-60

        mainPnl.add(testScrollPane);

        return mainPnl;
    }

    public App(){
        JMenuBar mainMenuBar = new JMenuBar();
        mainMenuBar.setVisible(true);

        JMenu menuActions = new JMenu("Akcje");
        JMenuItem menuLoadDB = new JMenuItem("Załaduj bazę danych");
        menuLoadDB.addActionListener(this);
        JMenuItem menuTestConnection = new JMenuItem("Test połączenia z bazą");
        menuTestConnection.addActionListener(this);
        JMenuItem menuSearch = new JMenuItem("Wyszukaj");
        menuSearch.addActionListener(this);
        JMenuItem menuFullList = new JMenuItem("Pełna lista kontaktów");
        menuFullList.addActionListener(this);
        JMenuItem menuExitApp = new JMenuItem("Wyjście");
        menuExitApp.addActionListener(this);

        mainMenuBar.add(menuActions);
        menuActions.add(menuLoadDB);
        menuActions.add(menuTestConnection);
        menuActions.add(menuSearch);
        menuActions.add(menuFullList);
        menuActions.add(menuExitApp);

        mainWindow = new JFrame("Sebastian Mastalerz - 4pp");
        mainWindow.setSize(360, 500);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setJMenuBar(mainMenuBar);
        mainWindow.setResizable(false);
        mainWindow.setContentPane(myCntPane());
        mainWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command){
            case("Załaduj bazę danych"):
                Connection connect = null;
                Properties settings = null;
                ArrayList<String> QUERYLoad = new ArrayList<>();

                JFileChooser openFile = new JFileChooser();
                openFile.setDialogTitle("Wybierz plik z kwerendą do wczytania");
                openFile.addChoosableFileFilter(new FileNameExtensionFilter("Query files", "sql", "text"));

                String fileText = "";

                // GET DATABASE INFO
                try {
                    settings = Test.loadProperties();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Ładowanie informacji o bazie danych nie powiodło się!",
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                // CREATE CONNECTION
                try {
                    connect = DriverManager.getConnection(settings.getProperty("url") + "mysql", settings.getProperty("user"), settings.getProperty("password"));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Połączenie nie powiodło się!",
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                // GET SELECTED .sql FILE AND GET ITS CONTENT INTO ONE VARIABLE
                int i = openFile.showOpenDialog(this);
                if (i == JFileChooser.APPROVE_OPTION) {
                    FileReader fr = null;
                    String line;

                    // OPENING THE FILE
                    try {
                        fr = new FileReader(openFile.getSelectedFile());
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Błąd przy otwieraniu pliku.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    BufferedReader bfr = new BufferedReader(fr);
                    // READING THE FILE AND MODIFYING THE CONTENTS
                    try {
                        while ((line = bfr.readLine()) != null) {
                            fileText += line;
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Błąd przy czytaniu pliku.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    // CLOSING THE FILE
                    try {
                        fr.close();
                    } catch (IOException ex) {
                         break;
                    }
                } else if (i == JFileChooser.CANCEL_OPTION) {
                    break;
                }

                try {
                    Statement stmt = connect.createStatement();

                    // SPLIT THE TEXT FROM THE VARIABLE INTO MULTIPLE QUERIES
                    String[] queryParts = fileText.split("(?<=;)");

                    for (int v = 0; v < queryParts.length; v++) {
                        queryParts[v] = queryParts[v].trim();

                        stmt.addBatch(queryParts[v]);
                    }

                    stmt.executeBatch();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Coś poszło nie tak \n" + ex.getMessage(),
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (NullPointerException ignored){}
                break;
            case("Test połączenia z bazą"):
                TAFullContactList.setText("");
                if(searchDialog != null){
                    searchDialog.dispose();
                }

                Test test = new Test();
                try {
                    test.testConnection();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Coś poszło nie tak",
                            "Błąd",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                break;
            case("Wyszukaj"):
                TAFullContactList.setText("");
                if(searchDialog != null){
                    searchDialog.dispose();
                }

                searchDialog = new JDialog(mainWindow, "Wyszukaj według nazwiska");
                searchDialog.setContentPane(new JPanel(null));
                searchDialog.setSize(350, 250);
                searchDialog.setVisible(true);

                JTextField TALastName = new JTextField();
                TALastName.setBounds(8,3, 220, 20);
                TALastName.setBackground(Color.LIGHT_GRAY);
                TALastName.setVisible(true);

                JButton BSearch = new JButton("Wyszukaj");
                BSearch.setBounds(229, 3, 100, 20);
                BSearch.setVisible(true);

                TAInfo = new JTextArea();
                TAInfo.setBounds(8, 24, 320, 225);
                TAInfo.setEditable(false);
                TAInfo.setBackground(Color.white);
                TAInfo.setVisible(true);

                BSearch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String lastName = TALastName.getText();
                        TALastName.setText("");

                        if(!lastName.isEmpty()) {
                            String QUERYFind = "SELECT imie, nazwisko, telefon, opis FROM kontakt WHERE nazwisko = '" + lastName + "';";
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
                                ResultSet result = stmt.executeQuery(QUERYFind);
                                if (!result.isBeforeFirst()) {
                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Nie udało się nam znaleźć takiej osoby, przepraszamy!",
                                            "Błąd",
                                            JOptionPane.ERROR_MESSAGE
                                    );
                                } else {
                                    while (result.next()) {
                                        TAInfo.setText("Imię: " + result.getString("imie") + "\n" +
                                                "Nazwisko: " + result.getString("nazwisko") + "\n" +
                                                "Telefon: " + result.getInt("telefon") + "\n" +
                                                "Opis: " + result.getString("opis"));
                                    }
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Coś poszło nie tak",
                                        "Błąd",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            } catch (NullPointerException ignored){}
                        } else {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Pole tekstowe jest puste.",
                                    "Błąd",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                });

                searchDialog.add(TALastName);
                searchDialog.add(TAInfo);
                searchDialog.add(BSearch);
                break;
            case("Pełna lista kontaktów"):
                TAFullContactList.setText("");
                if(searchDialog != null){
                    searchDialog.dispose();
                }

                Read reader = new Read(TAFullContactList);
                reader.readData();
                break;
            case("Wyjście"):
                System.exit(0);
                break;
        }
    }
}