/**
 * @autor Sebastian Mastalerz
 * @version 1.0
 * @date 15.04.2024
 * @desc Aplikacja desktopowa "Ksiazka Telefoniczna".
 * */

package Telefon;

public class Kontakt {
    protected String imie;
    protected String nazwisko;
    protected String telefon;
    protected String dataUr;
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getDataUr() {
        return dataUr;
    }

    public void setDataUr(String dataUr) {
        this.dataUr = dataUr;
    }

    public Kontakt(){
        this.imie = "Sebastian";
        this.nazwisko = "Mastalerz";
        this.telefon = "501413885";
        this.dataUr = "24/03/2005";
    }
    public Kontakt(String imie, String nazwisko, String telefon, String dataUr){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.dataUr = dataUr;
    }
}