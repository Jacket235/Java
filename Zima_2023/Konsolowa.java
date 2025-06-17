package Zima_2023;

import java.util.Scanner;

public class Konsolowa {
    /* * * * * * * * * * * * * * * * * * * * * * * * * * *
    nazwa funkcji:          NWD
    opis funkcji:           Funkcja wypisuje największy wspólny dzielnik dwóch liczb.
    parametry:              a - Pierwsza liczba
                            b - Druga liczba
    zwracany typ i opis:    Funkcja nic nie zwraca.
    autor:                  Sebek Mastalerz
    * * * * * * * * * * * * * * * * * * * * * * * * * * */
    static void NWD(int a, int b){

        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int liczba1 = skan.nextInt();
        int liczba2 = skan.nextInt();
        if (!(liczba1 > 0) || !(liczba2 > 0)) return;

        NWD(liczba1, liczba2);
    }
}









































