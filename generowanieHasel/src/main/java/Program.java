import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Clock;
import java.time.Year;
import java.util.ArrayList;
// slowo rok znak_specjalny  // ile hasel, roznych z pliku // pierwszy znak duzy, reszta male // combo box i hasla 10 lub 12 literowe

public class Program {
    ArrayList<String> haslaArrayList = new ArrayList<>();

    void readFileAndAddToArrayList(String pathname, String specialSymbol){
        FileReader fr = null;
        String linia = "";
        Year rok = Year.now(Clock.systemUTC());

        // OTWIERANIE PLIKU:
        try {
            fr = new FileReader(pathname);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR OPENING FILE!");
            System.exit(1);

        }

        BufferedReader bfr = new BufferedReader(fr);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try {
            while((linia = bfr.readLine()) != null){
                haslaArrayList.add(linia);
            }
            for (int i = 0; i < haslaArrayList.size(); i++){
                String word;
                word = haslaArrayList.get(i);
                String firstLetter = word.substring(0, 1);
                String restOfWord = word.substring(1);
                haslaArrayList.set(i, firstLetter.toUpperCase() + restOfWord.toLowerCase() + rok + specialSymbol);
            }
        } catch (IOException e) {
            System.out.println("ERROR READING FILE!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("ERROR CLOSING FILE!");
            System.exit(3);
        }
    }

    public void setHaslaArrayList(ArrayList<String> haslaArrayList) {
        this.haslaArrayList = haslaArrayList;
    }

    public ArrayList<String> getHaslaArrayList() {
        return haslaArrayList;
    }
}
