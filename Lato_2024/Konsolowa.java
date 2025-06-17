package Lato_2024;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;

public class Konsolowa {
    ArrayList<DataStructure> albumy = new ArrayList<>();

    public ArrayList<DataStructure> getAlbumy() {
        return albumy;
    }
    void wczytajAlbumy(){
        File file = new File("src/Lato_2024/Data.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            String album;
            int songsNumber;
            int year;
            int downloadNumber;

            while((line = br.readLine()) != null){
                if(line.isEmpty()) continue;

                album = br.readLine();
                songsNumber = Integer.parseInt(br.readLine());
                year = Integer.parseInt(br.readLine());
                downloadNumber = Integer.parseInt(br.readLine());
                albumy.add(new DataStructure(line, album, songsNumber, year, downloadNumber));
            }
        } catch(FileNotFoundException e){
            System.out.println("Nie udało się odczytać pliku");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void wypiszAlbumy(ArrayList<DataStructure> listaAlbumow){
        for (DataStructure album : listaAlbumow) {
            System.out.println("Artist: " + album.getArtist());
            System.out.println("Album: " + album.getAlbum());
            System.out.println("Number of Songs: " + album.getSongsNumber());
            System.out.println("Year: " + album.getYear());
            System.out.println("Downloads: " + album.getDownloadNumber());
            System.out.println();
        }
    }
}
