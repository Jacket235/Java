package Lato_2024;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Desktopowa {
    int indxAlbumu = 0;
    public JPanel myCntPane(){
        Konsolowa konsolowa = new Konsolowa();
        konsolowa.wczytajAlbumy();

        ArrayList<DataStructure> albumy = konsolowa.getAlbumy();

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.decode("#2E8B57"));

        Font defaultFont = new Font("Arial", Font.PLAIN, 20);

        JButton btnArwLeft = new JButton(new ImageIcon("src/Lato_2024/obraz3.png"));
        btnArwLeft.setBounds(30, 100, 96, 70);

        JButton btnArwRight = new JButton(new ImageIcon("src/Lato_2024/obraz2.png"));
        btnArwRight.setBounds(1060, 100, 96, 70);

        JLabel lblVinyl = new JLabel(new ImageIcon("src/Lato_2024/obraz.png"));
        lblVinyl.setBounds(160, 20, 200, 200);

        JLabel lblArtist = new JLabel("Gorillaz");
        lblArtist.setFont(new Font("Arial", Font.PLAIN, 50));
        lblArtist.setForeground(Color.white);
        lblArtist.setBounds(380, 40, 700, 50);

        JLabel lblAlbumName = new JLabel("\"The Now Now\"");
        lblAlbumName.setFont(new Font("Arial", Font.ITALIC, 30));
        lblAlbumName.setForeground(Color.white);
        lblAlbumName.setBounds(380, 100, 550, 50);

        JLabel lblSongsNumber = new JLabel("11 utworów");
        lblSongsNumber.setFont(defaultFont);
        lblSongsNumber.setForeground(Color.decode("#61D918"));
        lblSongsNumber.setBounds(380, 160, 150, 25);

        JLabel lblYear = new JLabel("2018");
        lblYear.setFont(defaultFont);
        lblYear.setForeground(Color.decode("#61D918"));
        lblYear.setBounds(530, 160, 100, 25);

        JLabel lblDownloadNumber = new JLabel("11000102");
        lblDownloadNumber.setFont(defaultFont);
        lblDownloadNumber.setForeground(Color.decode("#61D918"));
        lblDownloadNumber.setBounds(160, 250, 150, 25);

        JButton btnDownload = new JButton("Pobierz");
        btnDownload.setFont(new Font("Arial", Font.BOLD, 20));
        btnDownload.setBackground(Color.decode("#61D918"));
        btnDownload.setBounds(340, 245, 120, 35);

        btnDownload.addActionListener(e -> {
            int downloadNumber = Integer.parseInt(lblDownloadNumber.getText());
            lblDownloadNumber.setText(String.valueOf(downloadNumber + 1));
            konsolowa.getAlbumy().get(indxAlbumu).setDownloadNumber(konsolowa.getAlbumy().get(indxAlbumu).getDownloadNumber() + 1);
        });

        btnArwLeft.addActionListener(e -> {
            indxAlbumu--;

            if(indxAlbumu < 0) {
                indxAlbumu = konsolowa.getAlbumy().size() - 1;
            }

            lblArtist.setText(albumy.get(indxAlbumu).getArtist());
            lblAlbumName.setText(albumy.get(indxAlbumu).getAlbum());
            lblSongsNumber.setText(String.valueOf(albumy.get(indxAlbumu).getSongsNumber()));
            lblYear.setText(String.valueOf(albumy.get(indxAlbumu).getYear()));
            lblDownloadNumber.setText(String.valueOf(albumy.get(indxAlbumu).getDownloadNumber()));
        });

        btnArwRight.addActionListener(e -> {
            indxAlbumu++;

            if(indxAlbumu > konsolowa.getAlbumy().size() - 1) {
                indxAlbumu = 0;
            }

            lblArtist.setText(albumy.get(indxAlbumu).getArtist());
            lblAlbumName.setText(albumy.get(indxAlbumu).getAlbum());
            lblSongsNumber.setText(String.valueOf(albumy.get(indxAlbumu).getSongsNumber()));
            lblYear.setText(String.valueOf(albumy.get(indxAlbumu).getYear()));
            lblDownloadNumber.setText(String.valueOf(albumy.get(indxAlbumu).getDownloadNumber()));
        });

        mainPanel.add(btnArwLeft);
        mainPanel.add(btnArwRight);
        mainPanel.add(lblVinyl);
        mainPanel.add(lblArtist);
        mainPanel.add(lblAlbumName);
        mainPanel.add(lblSongsNumber);
        mainPanel.add(lblYear);
        mainPanel.add(lblDownloadNumber);
        mainPanel.add(btnDownload);

        return mainPanel;
    }
    public Desktopowa(){
        JFrame wndw = new JFrame("MojeDźwięki, Wykonał: 00000000000");
        wndw.setSize(1200, 340);
        wndw.setLocationRelativeTo(null);
        wndw.setContentPane(myCntPane());
        wndw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wndw.setVisible(true);
    }

    public static void main(String[] args) {
        new Desktopowa();
    }
}
