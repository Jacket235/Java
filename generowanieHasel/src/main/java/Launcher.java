import java.io.IOException;
import java.text.ParseException;

public class Launcher {
    //LANUCHER CLASS MAKES POSSIBLE TO USE JAVA FX 11 ON WINDOWS BY JAR BUT MAIN CLASS MUST BE LANUCHER
    public static void main(String[] args) throws ParseException, IOException {
        try {
            Main.main(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
