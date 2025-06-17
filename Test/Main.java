package Test;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/Test/dane.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String linia;
        while((linia = br.readLine()) != null){

        }
    }
}
