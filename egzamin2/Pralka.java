package egzamin2;

public class Pralka extends Urzadzenie {
    private int numerProgramu = 0;

    /**
     * nazwa:               setNumerProgramu
     * opis:                Metoda ta ustawia numer progrmau, który jest argumentem funkcji i potem go zwraca
     * parametry:           int numerProgrmau -  Numer programu pralki do ustawienia
     * zwracany typ i opis: int - Zwraca ustawiony numer programu
     * autor:               00000000000
     * */
    public int setNumerProgramu(int numerProgramu) {
        if(numerProgramu < 0 || numerProgramu > 12) {
            this.numerProgramu = 0;
            return 0;
        }
        this.numerProgramu = numerProgramu;

        return numerProgramu;
    }
}
