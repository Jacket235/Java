package Lato_2024;

public class DataStructure {
    public String artist;
    public String album;
    public int songsNumber;
    public int year;
    public int downloadNumber;

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }


    public int getSongsNumber() {
        return songsNumber;
    }

    public int getYear() {
        return year;
    }

    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }

    public DataStructure(String artist, String album, int songsNumber, int year, int downloadNumber){
        this.artist = artist;
        this.album = album;
        this.songsNumber = songsNumber;
        this.year = year;
        this.downloadNumber = downloadNumber;
    }
}
