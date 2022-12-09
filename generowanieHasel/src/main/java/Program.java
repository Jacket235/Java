import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Clock;
import java.time.Year;
import java.util.ArrayList;

public class Program {
    ArrayList<String> passwordArrayList = new ArrayList<>();

    void readFileAndAddToArrayList(String pathname, String specialSymbol){
        FileReader fr = null;
        String line = "";
        Year rok = Year.now(Clock.systemUTC());

        // OPENING THE FILE
        try {
            fr = new FileReader(pathname);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR OPENING FILE!");
            System.exit(1);

        }

        BufferedReader bfr = new BufferedReader(fr);
        // READING THE FILE AND MODIFYING THE CONTENTS
        try {
            while((line = bfr.readLine()) != null){
                passwordArrayList.add(line);
            }
            for (int i = 0; i < passwordArrayList.size(); i++){
                String word;
                word = passwordArrayList.get(i);
                String firstLetter = word.substring(0, 1);
                String restOfWord = word.substring(1);
                passwordArrayList.set(i, firstLetter.toUpperCase() + restOfWord.toLowerCase() + rok + specialSymbol);
            }
        } catch (IOException e) {
            System.out.println("ERROR READING FILE!");
            System.exit(2);
        }

        // CLOSING THE FILE
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("ERROR CLOSING FILE!");
            System.exit(3);
        }
    }

    public void setPasswordArrayList(ArrayList<String> haslaArrayList) {
        this.passwordArrayList = haslaArrayList;
    }

    public ArrayList<String> getPasswordArrayList() {
        return passwordArrayList;
    }
}