package egzamin2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        Pralka pralka = new Pralka();
        Odkurzacz odkurzacz = new Odkurzacz();

        System.out.println("Podaj numer prania 1..12");
        int wybranyProgram = skan.nextInt();
        if(wybranyProgram < 1 || wybranyProgram > 12) System.out.println("Podano niepoprawny numer programu");
        else{
            System.out.println("Program został ustawiony");
            pralka.setNumerProgramu(wybranyProgram);
        }

        odkurzacz.on();
        odkurzacz.on();
        odkurzacz.on();
        odkurzacz.wyswietlKomunikat("Odkurzacz wyładował się");
        odkurzacz.off();
    }
}
