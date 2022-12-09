import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;

public class Controler {
    @FXML
    TextField TFQuantity;
    @FXML
    ComboBox<String> CBSymbol;
    @FXML
    ComboBox<String> CBLength;
    @FXML
    void initialize (){
        CBSymbol.getItems().add("!");
        CBSymbol.getItems().add("@");
        CBSymbol.getItems().add("#");
        CBSymbol.getItems().add("$");
        CBSymbol.getItems().add("%");
        CBSymbol.getItems().add("*");
        CBSymbol.getItems().add("&");
        CBSymbol.getItems().add("(");
        CBSymbol.getItems().add(")");

        CBLength.getItems().add("10");
        CBLength.getItems().add("12");

        TFQuantity.setTextFormatter(new TextFormatter<Object>(c -> {
            if(c.getControlNewText().matches("^\\d*$")){
                return c;
            }
            return null;
        }));
    }
    public void getInfoAndCreatePasswords(){
        Program program = new Program();
        FileWriter fw;
        FileChooser fileChooser;
        String filepath;
        String specialSymbol = CBSymbol.getValue();
        int passAmount;
        int selectedLength;

        try {
            passAmount = Integer.parseInt(TFQuantity.getText());
            selectedLength = Integer.parseInt(CBLength.getValue());
            if(selectedLength == 10 && CBSymbol.getValue() != null){
                program.readFileAndAddToArrayList("10letterPasswords.txt", specialSymbol);
            } else if (selectedLength == 12 && CBSymbol.getValue() != null){
                program.readFileAndAddToArrayList("12letterPasswords.txt", specialSymbol);
            }

            fileChooser = new FileChooser();
            fileChooser.setTitle("Select a file where you want the passwords to save.");
            File file = fileChooser.showOpenDialog(Main.stage);
            if(file != null){
                filepath = file.toString();
                fw = new FileWriter(filepath);
                for (int i = 0; i < passAmount; i++){
                    int rnd = (int)(Math.random() * program.passwordArrayList.size());
                    fw.write(program.passwordArrayList.get(rnd));
                    program.passwordArrayList.remove(rnd);
                    fw.write("\n");
                }
                fw.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Success");
                alert.setContentText("The passwords have successfully saved to the file " + filepath);

                alert.showAndWait();
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Incorrect data/Unfilled form, or you're trying to generate too many passwords!");

            alert.showAndWait();
        }
    }
}