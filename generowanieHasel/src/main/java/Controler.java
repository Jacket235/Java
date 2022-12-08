import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;

public class Controler {
    @FXML
    TextField TFIlosc;
    @FXML
    ComboBox<String>  CBZnak;
    @FXML
    ComboBox<String> CBDlugosc;
    @FXML
    Button BGeneruj;
    @FXML
    void initialize (){
        CBZnak.getItems().add("!");
        CBZnak.getItems().add("@");
        CBZnak.getItems().add("#");
        CBZnak.getItems().add("$");
        CBZnak.getItems().add("%");
        CBZnak.getItems().add("*");
        CBZnak.getItems().add("&");
        CBZnak.getItems().add("(");
        CBZnak.getItems().add(")");
        CBDlugosc.getItems().add("10");
        CBDlugosc.getItems().add("12");
    }
    public void getInfoAndCreatePasswords(){
        Program program = new Program();
        int passAmount = 0;
        int selectedLength = 0;
        String specialSymbol = CBZnak.getValue();
        FileWriter fw = null;

        try {
            passAmount = Integer.parseInt(TFIlosc.getText());
            selectedLength = Integer.parseInt(CBDlugosc.getValue());
            if(selectedLength == 10 && CBZnak.getValue() != null){
                program.readFileAndAddToArrayList("haslaLiter10.txt", specialSymbol);
            } else if (selectedLength == 12 && selectedLength != 0 && CBZnak.getValue() != null){
                program.readFileAndAddToArrayList("haslaLiter12.txt", specialSymbol);
            }
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Where to save the file");
            File file = fileChooser.showOpenDialog(Main.stage);
            String filepath = "";
            if(file != null){
                filepath = file.toString();
                fw = new FileWriter(filepath);
                for (int i = 0; i < passAmount; i++){
                    fw.write(program.haslaArrayList.get((int)(Math.random() * (program.haslaArrayList.size()  + 1))));
                    fw.write("\n");
                }
                fw.close();
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Make sure you put in the correct data and filled the whole form in.");

            alert.showAndWait();
        }
    }
}
