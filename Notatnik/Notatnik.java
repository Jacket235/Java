/**
 * @Author Sebastian Mastalerz 4pp
 * @Date 02.10.2023
 * @Desc Notatnik własnej roboty.
 * @Version 1.0
 */


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class Notatnik extends Component implements ActionListener {

    JTextArea TATekstGlowny;
    String obecnaCzcionka = "Arial";
    int obecnyRozmiar = 12;

    public JPanel cntPane() {
        JPanel mainPanel = new JPanel(null);

        TATekstGlowny = new JTextArea();
        TATekstGlowny.setFont(new Font(obecnaCzcionka, Font.PLAIN, obecnyRozmiar));
        TATekstGlowny.setSize(885, 500);
        TATekstGlowny.setLineWrap(true);
        TATekstGlowny.setWrapStyleWord(true);
        TATekstGlowny.setVisible(true);
        mainPanel.add(TATekstGlowny);

        return mainPanel;
    }

    public Notatnik() {
        JFrame wndw = new JFrame("Notatnik");

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Plik");
        JMenuItem fileNew = new JMenuItem("Nowy");
        fileNew.addActionListener(this);
        fileNew.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem fileNewWndw = new JMenuItem("Nowe okno");
        fileNewWndw.addActionListener(this);
        fileNewWndw.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        JMenuItem fileOpen = new JMenuItem("Otwórz...");
        fileOpen.addActionListener(this);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem fileSave = new JMenuItem("Zapisz");
        fileSave.addActionListener(this);
        fileSave.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem fileSaveAs = new JMenuItem("Zapisz jako...");
        fileSaveAs.addActionListener(this);
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        JMenuItem filePageSettings = new JMenuItem("Ustawienia strony...");
        filePageSettings.addActionListener(this);
        JMenuItem filePrint = new JMenuItem("Drukuj...");
        filePrint.addActionListener(this);
        filePrint.setAccelerator(KeyStroke.getKeyStroke('P', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem fileEnd = new JMenuItem("Zakończ");
        fileEnd.addActionListener(this);

        JMenu edit = new JMenu("Edycja");
        JMenuItem editBack = new JMenuItem("Cofnij");
        editBack.addActionListener(this);
        editBack.setAccelerator(KeyStroke.getKeyStroke('Z', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editCut = new JMenuItem("Wytnij");
        editCut.addActionListener(this);
        editCut.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editCopy = new JMenuItem("Kopiuj");
        editCopy.addActionListener(this);
        editCopy.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editPaste = new JMenuItem("Wklej");
        editPaste.addActionListener(this);
        editPaste.setAccelerator(KeyStroke.getKeyStroke('V', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editDelete = new JMenuItem("Usuń");
        editDelete.addActionListener(this);
        editDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        JMenuItem editSearchBling = new JMenuItem("Wyszukaj za pomocą usługi Bling...");
        editSearchBling.addActionListener(this);
        editSearchBling.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editFind = new JMenuItem("Znajdź...");
        editFind.addActionListener(this);
        editFind.setAccelerator(KeyStroke.getKeyStroke('F', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editFindNext = new JMenuItem("Znajdź następny");
        editFindNext.addActionListener(this);
        editFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        JMenuItem editFindPrevious = new JMenuItem("Znajdź poprzednie");
        editFindPrevious.addActionListener(this);
        editFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        JMenuItem editReplace = new JMenuItem("Zamień...");
        editReplace.addActionListener(this);
        editReplace.setAccelerator(KeyStroke.getKeyStroke('H', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editGoTo = new JMenuItem("Przejdź do...");
        editGoTo.addActionListener(this);
        editGoTo.setAccelerator(KeyStroke.getKeyStroke('G', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editSelectAll = new JMenuItem("Zaznacz wszystko");
        editSelectAll.addActionListener(this);
        editSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem editHourDate = new JMenuItem("Godzina/data");
        editHourDate.addActionListener(this);
        editHourDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

        JMenu format = new JMenu("Format");
        JMenuItem formatLineWrap = new JMenuItem("Zawijanie wierszy");
        formatLineWrap.addActionListener(this);
        JMenuItem formatFontStyle = new JMenuItem("Czcionka");
        formatFontStyle.addActionListener(this);
        JMenuItem formatFontColor = new JMenuItem("Kolor czcionki");
        formatFontColor.addActionListener(this);
        JMenuItem formatFontSize = new JMenuItem("Rozmiar czcionki");
        formatFontSize.addActionListener(this);

        JMenu view = new JMenu("Widok");
        JMenu viewZoom = new JMenu("Powiększenie");
        JMenuItem viewMakeBig = new JMenuItem("Powiększ");
        viewMakeBig.addActionListener(this);
        viewMakeBig.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.getExtendedKeyCodeForChar('+'), KeyEvent.CTRL_DOWN_MASK));
        JMenuItem viewMakeSmall = new JMenuItem("Pomniejsz");
        viewMakeSmall.addActionListener(this);
        viewMakeSmall.setAccelerator(KeyStroke.getKeyStroke('-', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem viewDefault = new JMenuItem("Przywróć powiększenie domyślne");
        viewDefault.addActionListener(this);
        viewDefault.setAccelerator(KeyStroke.getKeyStroke('0', KeyEvent.CTRL_DOWN_MASK));
        JMenuItem viewMenuStatus = new JMenuItem("Pasek stanu");
        viewMenuStatus.addActionListener(this);

        JMenu help = new JMenu("Pomoc");
        JMenuItem helpShow = new JMenuItem("Wyświetl Pomoc");
        helpShow.addActionListener(this);
        JMenuItem helpSendOpinion = new JMenuItem("Wyślij opinię");
        helpSendOpinion.addActionListener(this);
        JMenuItem helpInfo = new JMenuItem("Notatnik - informacje");
        helpInfo.addActionListener(this);

        menuBar.add(file);
        file.add(fileNew);
        file.add(fileNewWndw);
        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileSaveAs);
        file.addSeparator();
        file.add(filePageSettings);
        file.add(filePrint);
        file.addSeparator();
        file.add(fileEnd);

        menuBar.add(edit);
        edit.add(editBack);
        edit.add(editCut);
        edit.add(editCopy);
        edit.add(editPaste);
        edit.add(editDelete);
        edit.addSeparator();
        edit.add(editSearchBling);
        edit.add(editFind);
        edit.add(editFindNext);
        edit.add(editFindPrevious);
        edit.add(editReplace);
        edit.add(editGoTo);
        edit.addSeparator();
        edit.add(editSelectAll);
        edit.add(editHourDate);

        menuBar.add(format);
        format.add(formatLineWrap);
        format.addSeparator();
        format.add(formatFontStyle);
        format.add(formatFontSize);
        format.add(formatFontColor);

        menuBar.add(view);
        view.add(viewZoom);
        viewZoom.add(viewMakeBig);
        viewZoom.add(viewMakeSmall);
        viewZoom.add(viewDefault);
        view.add(viewMenuStatus);

        menuBar.add(help);
        help.add(helpShow);
        help.add(helpSendOpinion);
        help.addSeparator();
        help.add(helpInfo);

        wndw.setSize(900, 500);
        wndw.setLocationRelativeTo(null);
        wndw.setResizable(false);
        wndw.setJMenuBar(menuBar);
        wndw.setContentPane(cntPane());
        wndw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wndw.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case ("Notatnik - informacje"):
                JOptionPane.showMessageDialog(
                        null,
                        "Sebastian Mastalerz\n Klasa 4pp\n Projekt 'Notatnik'.",
                        "Błąd",
                        JOptionPane.INFORMATION_MESSAGE
                );
                break;
            case ("Czcionka"):
                String[] czcionki = {"Arial", "Calibri", "Comic Sans MS", "Cooper Black"};
                JComboBox wybierzCzcionke = new JComboBox(czcionki);
                JOptionPane.showMessageDialog(this, wybierzCzcionke, "Wybierz czcionke", JOptionPane.QUESTION_MESSAGE);
                obecnaCzcionka = (String) wybierzCzcionke.getSelectedItem();
                TATekstGlowny.setFont(new Font(obecnaCzcionka, Font.PLAIN, obecnyRozmiar));
                break;
            case ("Kolor czcionki"):
                Color wybranyKolorCzcionki = JColorChooser.showDialog(
                        this,
                        "Wybierz kolor czcionki",
                        Color.BLACK);
                TATekstGlowny.setForeground(wybranyKolorCzcionki
                );
                break;
            case ("Rozmiar czcionki"):
                Object[] rozmiary = {11, 12, 14, 16, 18, 20, 22, 24, 26, 28, 36, 48, 72};
                try {
                    int wybranyRozmiarCzcionki = (int) JOptionPane.showInputDialog(
                            null,
                            "Wybierz rozmiar czcionki",
                            "Rozmiar czcionki edytora",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            rozmiary,
                            obecnyRozmiar
                    );
                    obecnyRozmiar = wybranyRozmiarCzcionki;
                    TATekstGlowny.setFont(new Font(obecnaCzcionka, Font.PLAIN, obecnyRozmiar));
                    break;
                } catch (Exception except) {
                    JOptionPane.showMessageDialog(this, except.getMessage(), "Coś poszło nie tak", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case ("Nowy"):
                TATekstGlowny.setText("");
                break;
            case ("Nowe okno"):
                new Notatnik();
                break;
            case ("Otwórz..."):
                JFileChooser openFile = new JFileChooser();
                openFile.setDialogTitle("Wybierz plik do odczytu");
                openFile.addChoosableFileFilter(new FileNameExtensionFilter("Text File", "txt", "text"));

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
                            TATekstGlowny.append(line + "\n");
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Błąd przy czytaniu pliku.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    // CLOSING THE FILE
                    try {
                        fr.close();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Błąd przy zamykaniu pliku.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                break;
            case ("Zapisz"):
                JFileChooser saveFile = new JFileChooser();
                saveFile.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt", "text"));
                saveFile.setDialogTitle("Wybierz plik do którego zapisać.");
                int k = saveFile.showSaveDialog(this);
                if (k == JFileChooser.APPROVE_OPTION) {
                    FileWriter fw;
                    File file = saveFile.getSelectedFile();

                    if (!file.toString().contains(".txt")) {
                        file = new File(saveFile.getSelectedFile() + ".txt");
                    }

                    try {
                        fw = new FileWriter(file);
                        fw.write(TATekstGlowny.getText());

                        fw.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Błąd przy zapisywaniu pliku.", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
                break;
            case ("Zakończ"):
                System.exit(0);
                break;
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

    public static void main(String[] args) {
        new Notatnik();
    }
}