package Lato_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Kostki {
    ArrayList<Integer> kostki = new ArrayList<>();

    public ArrayList<Integer> getKostki() {
        return kostki;
    }

    void wypiszKostki(ArrayList<Integer> kostki){
        for(int i = 0; i < kostki.size(); i++){
            System.out.println("Kostka " + (i + 1) + ": " + kostki.get(i));
        }
    }

    int wynikKostek(ArrayList<Integer> kostki){
        int wynik = 0;
        HashMap<Integer, Integer> powtorzenia = new HashMap<>();

        for(Integer num : kostki){
            if(powtorzenia.containsKey(num)){
                powtorzenia.put(num, powtorzenia.get(num) + 1);
            } else {
                powtorzenia.put(num, 1);
            }
        }

        for(Integer k : powtorzenia.keySet()){
            int v = powtorzenia.get(k);
            if(v != 1){
                wynik += k * v;
            }
        }

        return wynik;
    }

    void wylosujKostki(ArrayList<Integer> kostki, int iloscKostek){
        Random rand = new Random();
        for(int i = 0; i < iloscKostek; i++){
            kostki.add(rand.nextInt(6) + 1);
        }
    }

    void graj(){
        Scanner skan = new Scanner(System.in);
        System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
        int iloscKostekDoRzucenia = skan.nextInt();
        if(iloscKostekDoRzucenia < 3 || iloscKostekDoRzucenia > 10) {
            graj();
            return;
        }

        wylosujKostki(getKostki(), iloscKostekDoRzucenia);
        wypiszKostki(getKostki());

        System.out.println("Liczba uzyskanych punktów: " + wynikKostek(getKostki()));
        System.out.println("Jeszcze raz? (t/n)");
        if(skan.next().charAt(0) == 't') graj();
    }

    public static void main(String[] args) {
        new Kostki().graj();
    }
}
