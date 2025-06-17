/**
 * @author Sebastian Mastalerz
 * @version 1.0
 * @since 23-10-2023
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Wisielec {

    int dlugoscSlowa = 0;
    char[] wybraneLosSlowo;
    char[] zgadujSlowo;
    int wndwW = 800;
    int wndwH = 450;
    int gamePnlW = (int) (wndwW * .875);
    int gamePnlH = (int) (wndwH * .6);
    Font defaultFont = new Font("Tahoma", Font.PLAIN, 12);

    public JPanel myCntPane() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.green);

        JPanel gamePanel = new JPanel(null);
        mainPanel.add(gamePanel);

        JLabel LZgaduj = new JLabel("Zgaduj wyraz");
        LZgaduj.setLocation((int) wndwW / 2 - 100, (int) (wndwH * .05));
        LZgaduj.setHorizontalAlignment(JLabel.CENTER);
        LZgaduj.setFont(defaultFont);
        LZgaduj.setOpaque(true);
        LZgaduj.setBackground(Color.black);
        LZgaduj.setForeground(Color.white);
        LZgaduj.setSize(200, 25);
        LZgaduj.setVisible(true);

        JButton BLosuj = new JButton("Losuj słowo");
        BLosuj.setFont(defaultFont);
        BLosuj.setLocation((int) wndwW / 2 - 50, (int) (wndwH * .12));
        BLosuj.setSize(100, 25);
        BLosuj.setVisible(true);

        mainPanel.add(LZgaduj);
        mainPanel.add(BLosuj);

        gamePanel.setLocation((int) (wndwW * .05), (int) (wndwH * .25));
        gamePanel.setSize(gamePnlW, gamePnlH);

        JLabel LiloscLiter = new JLabel();
        LiloscLiter.setHorizontalAlignment(JLabel.CENTER);
        LiloscLiter.setFont(defaultFont);
        LiloscLiter.setSize(50, 25);
        LiloscLiter.setForeground(Color.white);
        LiloscLiter.setBackground(Color.black);
        LiloscLiter.setOpaque(true);
        LiloscLiter.setLocation((int) (gamePnlW / 2) - 25, 20);
        LiloscLiter.setVisible(true);

        JLabel LpodajLitere = new JLabel("Podaj literę");
        LpodajLitere.setHorizontalAlignment(JLabel.CENTER);
        LpodajLitere.setFont(defaultFont);
        LpodajLitere.setBackground(Color.black);
        LpodajLitere.setForeground(Color.white);
        LpodajLitere.setOpaque(true);
        LpodajLitere.setLocation((int) (gamePnlW * .2), (int) (gamePnlH * .8));
        LpodajLitere.setSize(200, 25);
        LpodajLitere.setVisible(true);

        JLabel LSlowo = new JLabel();
        LSlowo.setFont(defaultFont);
        LSlowo.setHorizontalAlignment(JLabel.CENTER);
        LSlowo.setSize(400, 40);
        LSlowo.setLocation((int) (gamePnlW * .5) - 200, (int) (gamePnlH * .4));
        LSlowo.setVisible(true);

        JTextField TFLitera = new JTextField();
        TFLitera.setLocation((int) (gamePnlW * .5), (int) (gamePnlH * .8));
        TFLitera.setEnabled(false);
        TFLitera.setSize(200, 25);
        TFLitera.setVisible(true);

        JButton nowaGraButt = new JButton("Nowa gra");
        nowaGraButt.setLocation((int) ((gamePnlW * .5 ) - 50), (int) ((gamePnlH * .35) - 15));
        nowaGraButt.setSize(100, 30);
        nowaGraButt.setVisible(false);

        JLabel LwygranaPrzegrana = new JLabel("");
        LwygranaPrzegrana.setLocation((int) ((gamePnlW * .525) - 50), (int) ((gamePnlH * .25) - 15));
        LwygranaPrzegrana.setSize(100, 30);
        LwygranaPrzegrana.setVisible(false);

        nowaGraButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BLosuj.setEnabled(true);
                nowaGraButt.setVisible(false);
                LSlowo.setText("");
                LwygranaPrzegrana.setText("");
                LwygranaPrzegrana.setVisible(false);
                LiloscLiter.setText("");
            }
        });

        BLosuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TFLitera.setText("");
                LwygranaPrzegrana.setText("");
                LwygranaPrzegrana.setVisible(false);
                BLosuj.setEnabled(false);
                TFLitera.setEnabled(true);
                FileReader fr = null;
                String line;

                // OPENING THE FILE
                try {
                    fr = new FileReader("C:/Users/klasa4pp/IdeaProjects/Zgadula/src/lista.txt");
                } catch (FileNotFoundException ex) {
                    // silent catch
                }

                BufferedReader bfr = new BufferedReader(fr);
                // READING THE FILE
                try {
                    String[] slowa = new String[20];
                    int losSlowo = (int)(Math.random() * 20);

                    int i = 0;
                    while ((line = bfr.readLine()) != null) { // Uzupełnia tabele ze słowami, słowami podanymi w pliku .txt
                        slowa[i] = line;
                        i++;
                    }
                    wybraneLosSlowo = slowa[losSlowo].toCharArray();
                    dlugoscSlowa = wybraneLosSlowo.length;
                    zgadujSlowo = new char[dlugoscSlowa];
                    LiloscLiter.setText(String.valueOf(dlugoscSlowa));
                    String tmp = "";
                    for(int j = 0; j < wybraneLosSlowo.length; j++){ // Na sam początek tablica jest uzupełniana '_'
                        zgadujSlowo[j] = '_';
                        tmp += zgadujSlowo[j] + " ";
                    }
                    LSlowo.setText(tmp); // Ustawić pustego labela (pusty czyli z samymi '_')
                } catch (IOException ex) {
                    // silent catch
                }

                // CLOSING THE FILE
                try {
                    fr.close();
                } catch (IOException ex) {
                    // silent catch
                }
            }
        });

        TFLitera.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if(TFLitera.getText().length() > 0) e.consume(); // Żeby nie można było wpisać więcej niż jeden znak do TextFielda

                if(!Character.isLetter(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) e.consume(); // Żeby można było wpisywać tylko litery.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int pressedButt = e.getKeyCode();
                boolean czyZgadnieto = false;

                /**
                 * Jak nacisnie się enter, gdy jest się skupionym na TextField
                 * to sprawdza, czy jest pusty, jak nie to sprawdza, czy któraś
                 * litera się zgadza, jak tak to odkrywana jest w słowie i nie
                 * tracimy życia, a jak nie to odejmuje sie życie.
                 * */
                if (pressedButt == 10) {
                    if(TFLitera.getText() == null || TFLitera.getText().equals("")){
                        System.out.println("WPROWADZ LITERE");
                    } else{
                        char tmp = Character.toLowerCase(TFLitera.getText().charAt(0)); // Bierze wpisana litere i zamienia ja na małą
                        for(int k = 0; k < wybraneLosSlowo.length; k++){
                            if(tmp == wybraneLosSlowo[k]){
                                zgadujSlowo[k] = tmp;
                                czyZgadnieto = true;
                            }
                        }
                        if(!czyZgadnieto){ // Jezeli nie zgadnieto litery to odejmujemy życie
                            dlugoscSlowa--;
                        }
                        LiloscLiter.setText(String.valueOf(dlugoscSlowa)); // Odswieżyć liczbe żyć
                    }
                    String noweSlowo = "";
                    for(int i = 0; i < zgadujSlowo.length;i++){ // Uzupełnić tabelę zgadniętą literą, która zawiera litery odkryte.
                        noweSlowo += zgadujSlowo[i] + " ";
                    }

                    boolean czyWygrana = false;

                    for(int v = 0; v < zgadujSlowo.length; v++){
                        if(zgadujSlowo[v] == wybraneLosSlowo[v]){ // Jezeli wszystkie litery się zgadzaja to czyWygrana pozostaje jako true
                            czyWygrana = true;
                        }else {
                            czyWygrana = false;
                            break;
                        }
                    }

                    TFLitera.setText(""); // Czyści TextFielda
                    LSlowo.setText(noweSlowo); // Odświeża labela z odkrytymi literami

                    if (czyWygrana){ // Jeżeli czyWygrana pozostało jako true, to gra się kończy
                        nowaGraButt.setVisible(true);
                        LwygranaPrzegrana.setText("Wygrana");
                        LwygranaPrzegrana.setForeground(Color.green);
                        LwygranaPrzegrana.setVisible(true);
                        TFLitera.setEnabled(false);
                        return;
                    }

                    if(dlugoscSlowa == 0){ // Jeżeli nie ma żyć, to gra się kończy
                        nowaGraButt.setVisible(true);
                        LwygranaPrzegrana.setVisible(true);
                        LwygranaPrzegrana.setForeground(Color.red);
                        LwygranaPrzegrana.setText("Przegrana");
                        TFLitera.setEnabled(false);
                        return;
                    }
                }
            }
        });

        gamePanel.add(TFLitera);
        gamePanel.add(LwygranaPrzegrana);
        gamePanel.add(LSlowo);
        gamePanel.add(LpodajLitere);
        gamePanel.add(LiloscLiter);
        gamePanel.add(nowaGraButt);

        return mainPanel;
    }

    public Wisielec() {
        JFrame mainWndw = new JFrame("Sebastian Mastalerz 4pp - Wisielec 1");
        mainWndw.setSize(wndwW, wndwH);
        mainWndw.setContentPane(myCntPane());
        mainWndw.setResizable(false);
        mainWndw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWndw.setVisible(true);
    }

    public static void main(String[] args) {
        new Wisielec();
    }
}
