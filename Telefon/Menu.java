/**
 * @autor Sebastian Mastalerz
 * @version 1.0
 * @date 15.04.2024
 * @desc Aplikacja desktopowa "Ksiazka Telefoniczna".
 * */

package Telefon;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu extends Component implements ActionListener {
    private final JMenuBar menuBar;
    private final App app;
    public JMenuBar getMenuBar() {
        return menuBar;
    }
    public Menu(App app){
        this.app = app;
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.blue);
        JMenu menu = new JMenu("Menu");
        menu.setForeground(Color.white);

        JMenuItem dodajKontakt = new JMenuItem("Dodaj kontakt");
        dodajKontakt.setAccelerator(KeyStroke.getKeyStroke('D', KeyEvent.CTRL_DOWN_MASK));
        dodajKontakt.addActionListener(this);
        JMenuItem usunKontakt = new JMenuItem("Usuń kontakt");
        usunKontakt.setAccelerator(KeyStroke.getKeyStroke('U', KeyEvent.CTRL_DOWN_MASK));
        usunKontakt.addActionListener(this);
        JMenuItem szukajKontakt = new JMenuItem("Szukaj w/g nazwiska");
        szukajKontakt.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        szukajKontakt.addActionListener(this);
        JMenuItem solenizantKontakt = new JMenuItem("Solenizant");
        solenizantKontakt.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_DOWN_MASK));
        solenizantKontakt.addActionListener(this);
        JMenuItem wszystkieKontakt = new JMenuItem("Wszystkie kontakty");
        wszystkieKontakt.setAccelerator(KeyStroke.getKeyStroke('W', KeyEvent.CTRL_DOWN_MASK));
        wszystkieKontakt.addActionListener(this);
        JMenuItem clear = new JMenuItem("Wyczyść");
        clear.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_DOWN_MASK));
        clear.addActionListener(this);
        JMenuItem exit = new JMenuItem("Wyjście");
        exit.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_DOWN_MASK));
        exit.addActionListener(this);

        menuBar.add(menu);
        menu.add(dodajKontakt);
        menu.add(usunKontakt);
        menu.add(szukajKontakt);
        menu.add(solenizantKontakt);
        menu.add(wszystkieKontakt);
        menu.addSeparator();
        menu.add(clear);
        menu.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch(cmd){
            case("Dodaj kontakt"):
                app.showAddContactPanel();
                break;
            case("Usuń kontakt"):
                break;
            case("Szukaj w/g nazwiska"):
                break;
            case("Solenizant"):
                break;
            case("Wszystkie kontakty"):
                break;
            case("Wyczyść"):
                app.clearPanel();
                break;
            case("Wyjście"):
                System.exit(0);break;
            default:
                JOptionPane.showMessageDialog(
                        null,
                        "Opcja '" + e.getActionCommand() + "' nie jest dostępna.",
                        "Błąd",
                        JOptionPane.ERROR_MESSAGE
                );
                break;
        }
    }
}