package Poczta;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Przesylka {

    public JPanel myCntPane() {
        JPanel mainPnl = new JPanel(null);

        JButton buttSprawdzCene = new JButton("Sprawdź cenę");
        buttSprawdzCene.setBounds(30, 130, 180, 20);

        JLabel labelIMG = new JLabel(new ImageIcon("src\\Poczta\\pocztowka.png"));
        labelIMG.setBounds(30, 160, 100, 60);

        JButton buttZatwierdz = new JButton("Zatwierdź");
        buttZatwierdz.setBounds(50, 240, 500, 20);

        JLabel labelCena = new JLabel("Cena: 1 zł");
        labelCena.setFont(new Font("Arial", Font.BOLD, 16));
        labelCena.setBounds(150, 160, 100, 25);
        labelCena.setVisible(true);

        JPanel rodzajPnl = new JPanel();
        rodzajPnl.setLayout(new BoxLayout(rodzajPnl, BoxLayout.PAGE_AXIS));
        rodzajPnl.setBounds(30, 25, 180, 100);
        rodzajPnl.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        rodzajPnl.setBorder(new TitledBorder("Rodzaj przesyłki"));
        rodzajPnl.setVisible(true);

        JRadioButton radioPocztowka = new JRadioButton("Pocztówka");
        radioPocztowka.setActionCommand("Pocztówka");
        radioPocztowka.setSelected(true);
        JRadioButton radioList = new JRadioButton("List");
        radioList.setActionCommand("List");
        JRadioButton radioPaczka = new JRadioButton("Paczka");
        radioPaczka.setActionCommand("Paczka");

        ButtonGroup RBBG = new ButtonGroup();
        RBBG.add(radioPocztowka);
        RBBG.add(radioList);
        RBBG.add(radioPaczka);

        buttSprawdzCene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wybor = RBBG.getSelection().getActionCommand();

                switch (wybor) {
                    case ("Pocztówka") -> {
                        labelCena.setText("Cena: 1 zł");
                        labelIMG.setIcon(new ImageIcon("src\\Poczta\\pocztowka.png"));
                    }
                    case ("List") -> {
                        labelCena.setText("Cena: 1,5 zł");
                        labelIMG.setIcon(new ImageIcon("src\\Poczta\\koperta.png"));
                    }
                    case ("Paczka") -> {
                        labelCena.setText("Cena: 10 zł");
                        labelIMG.setIcon(new ImageIcon("src\\Poczta\\paczka.jpg"));
                    }
                }

            }
        });

        JPanel danePnl = new JPanel(null);
        danePnl.setBounds(300, 25, 250, 180);
        danePnl.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        danePnl.setBorder(new TitledBorder("Dane adresowe"));
        danePnl.setVisible(true);

        JLabel labelUlica = new JLabel("Ulica z numerem");
        labelUlica.setBounds(20, 20, 100, 30);
        labelUlica.setVisible(true);

        JTextArea TAUlica = new JTextArea();
        TAUlica.setBounds(20, 45, 210, 20);
        TAUlica.setBorder(BorderFactory.createLoweredBevelBorder());
        TAUlica.setVisible(true);

        JLabel labelKod = new JLabel("Kod pocztowy");
        labelKod.setBounds(20, 70, 100, 30);
        labelKod.setVisible(true);

        JTextArea TAKod = new JTextArea();
        TAKod.setBounds(20, 95, 110, 20);
        TAKod.setBorder(BorderFactory.createLoweredBevelBorder());
        TAKod.setVisible(true);

        TAKod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (TAKod.getText().length() > 4) {
                    e.consume();
                }
            }
        });

        JLabel labelMiasto = new JLabel("Miasto");
        labelMiasto.setBounds(20, 120, 100, 30);
        labelMiasto.setVisible(true);

        JTextArea TAMiasto = new JTextArea();
        TAMiasto.setBounds(20, 145, 210, 20);
        TAMiasto.setBorder(BorderFactory.createLoweredBevelBorder());
        TAMiasto.setVisible(true);

        buttZatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!TAMiasto.getText().isEmpty() && !(TAUlica.getText().isEmpty())) {
                    // Sprawdza, czy kod pocztowy nie jest za krótki.
                    if (TAKod.getText().length() < 5) {
                        JOptionPane.showMessageDialog(null, "Nieprawidłowa liczba cyfr w kodzie pocztowym", "Błąd", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    // Sprawdza, czy kod pocztowy zawiera jakąś literę.
                    for (int i = 0; i < TAKod.getText().length(); i++) {
                        if (!Character.isDigit(TAKod.getText().charAt(i))) {
                            JOptionPane.showMessageDialog(null, "Kod pocztowy powinien się składać samych cyfr", "Błąd", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    // Jeżeli żadne ze wcześniejszych warunków nie zostało spełnione, to znaczy, że wszystko jest dobrze i ma wyświetlić poniższy komunikat.
                    JOptionPane.showConfirmDialog(mainPnl, "Dane przesyłki zostały wprowadzone", "Sukces", JOptionPane.DEFAULT_OPTION);
                }
            }
        });

        mainPnl.add(rodzajPnl);
        mainPnl.add(danePnl);
        mainPnl.add(buttSprawdzCene);
        mainPnl.add(labelIMG);
        mainPnl.add(buttZatwierdz);
        mainPnl.add(labelCena);

        rodzajPnl.add(radioPocztowka);
        rodzajPnl.add(radioList);
        rodzajPnl.add(radioPaczka);

        danePnl.add(labelUlica);
        danePnl.add(TAUlica);
        danePnl.add(labelKod);
        danePnl.add(TAKod);
        danePnl.add(labelMiasto);
        danePnl.add(TAMiasto);

        return mainPnl;
    }

    public Przesylka() {
        JFrame window = new JFrame("Nadaj przesyłkę, PESEL 00000000000 ");

        window.setSize(600, 300);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setContentPane(myCntPane());
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Przesylka();
    }
}
