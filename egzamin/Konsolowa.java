package egzamin;

import java.util.Random;

public class Konsolowa {
    private int[] tab;

    private int tabSize;
    void wypiszTablice(){
        for(int i = 0; i < this.tabSize; i++){
            System.out.println(i + ": " + tab[i]);
        }
    }

    int szukajElementu(int szukanyElement){
        for(int i = 0; i < this.tabSize; i++){
            if(tab[i] == szukanyElement) return i;
        }

        return -1;
    }

    int szukajNieparzyste(){
        int liczbaNieparzystych = 0;

        System.out.println("Liczby nieparzyste:");
        for(int i = 0; i < this.tabSize; i++){
            if(tab[i] % 2 != 0){
                System.out.println(tab[i]);
                liczbaNieparzystych++;
            }
        }

        return liczbaNieparzystych;
    }

    int sredniaElementow() {
        int suma = 0;

        for(int i = 0; i < this.tabSize; i++){
            suma += tab[i];
        }

        return suma / this.tabSize;
    }

    public Konsolowa(int tabSize){
        this.tabSize = tabSize;
        this.tab = new int[tabSize];

        Random rand = new Random();

        for(int i = 0; i < this.tabSize; i++){
            tab[i] = rand.nextInt(1000) + 1;
        }
    }

    public static void main(String[] args) {
        Konsolowa konsolowa = new Konsolowa(21);
        int szukanyElement = konsolowa.szukajElementu(183);

        konsolowa.wypiszTablice();
        if(szukanyElement != -1) System.out.println(szukanyElement);;
        System.out.println("Razem nieparzystych: " + konsolowa.szukajNieparzyste());
        System.out.println("Średnia wszystkich elementów: " + konsolowa.sredniaElementow());
    }
}
