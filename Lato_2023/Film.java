package Lato_2023;

/*
* nazwa klasy: Film
* pola:         tytul - Tytuł filmu
*               liczbaWypozyczen - Ilość wypożyczeń danego filmu
* metody:       getTytul, String - Pobiera pole "tytul" klasy  i je zwraca
*               setTytul, void - Ustawia wartość dla pola tytul klasy
*               getLiczbaWypozyczen, int - Pobiera pole "liczaWypozyczen" klasy  i je zwraca
*               inkrementujLiczbeWypozyczen, void - Inkrementuje pole "liczbaWypozyczen" klasy
* informacje:   <opis>
* autor:        00000000000
* */
public class Film {
    private String tytul;
    private int liczbaWypozyczen;

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getLiczbaWypozyczen() {
        return liczbaWypozyczen;
    }

    public void inkrementujLiczbeWypozyczen(){
        this.liczbaWypozyczen = this.liczbaWypozyczen + 1;
    }

    public Film(){
        this.tytul = "";
        this.liczbaWypozyczen = 0;
    }

    public static void main(String[] args) {
        Film film = new Film();
        System.out.println("Tytuł filmu: " + film.getTytul() + "\nLiczba wypożyczeń: " + film.getLiczbaWypozyczen());
        film.setTytul("Star Wars");
        System.out.println("Tytuł filmu po ustawieniu: " + film.getTytul());
        System.out.println("Liczba wypożyczeń przed inkrementacją: " + film.getLiczbaWypozyczen());
        film.inkrementujLiczbeWypozyczen();
        System.out.println("Liczba wypożyczeń przed inkrementacją: " + film.getLiczbaWypozyczen());
    }
}
