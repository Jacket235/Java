package egzamin2;

public class Odkurzacz extends Urzadzenie{
    private boolean stanOdkurzacza = false;

    /**
     * nazwa:               on
     * opis:                Metoda ta włącza odkurzacz poprzez ustawienie pola stanOdkurzacz na false i wyświetla komunikat
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     * */
    public void on(){
        if(this.stanOdkurzacza) return;
        this.stanOdkurzacza = true;
        wyswietlKomunikat("Odkurzacz włączono");
    }

    /**
     * nazwa:               off
     * opis:                Metoda ta wyłącza odkurzacz poprzez ustawienie pola stanOdkurzacz na false
     * parametry:           brak
     * zwracany typ i opis: brak
     * autor:               00000000000
     * */
    public void off(){
        this.stanOdkurzacza = false;
        wyswietlKomunikat("Odkurzacz wyłączono");
    }
}