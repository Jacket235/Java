/**
 * @autor Sebastian Mastalerz
 * @version 1.0
 * @date 15.04.2024
 * @desc Aplikacja desktopowa "Ksiazka Telefoniczna".
 * */

package Telefon;

import java.util.ArrayList;

public class Dane {
    ArrayList<Kontakt> kontakty = new ArrayList<>();

    public ArrayList<Kontakt> getKontakty() {
        return kontakty;
    }
}