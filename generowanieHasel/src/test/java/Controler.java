import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
        try {
            passAmount = Integer.parseInt(TFIlosc.getText());
            selectedLength = Integer.parseInt(CBDlugosc.getValue());
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Given data is incorrect");
            alert.setContentText("Make sure you put in the correct data and filled the whole form in.");

            alert.showAndWait();
        }
        String specialSymbol = CBZnak.getValue();

        if (passAmount == 0 || specialSymbol == "" || selectedLength == 0){
            // do nothing
        } else {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Open resource file");
//            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt", "*.txt"));
//            File file = fileChooser.showOpenDialog(Main.stage);
//            String filepath = "";
//            if(file != null){
//                filepath = file.toString();
//            }

            if(selectedLength == 10){
                try{
                    program.readFileAndAddToArrayList("haslaLiter10.txt", specialSymbol);
                } catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Given data is incorrect");
                    alert.setContentText("You're trying to generate more passwords than there are words in the file!");

                    alert.showAndWait();
                }

            } else{
                try{
                    program.readFileAndAddToArrayList("haslaLiter12.txt", specialSymbol);
                } catch (Exception e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Given data is incorrect");
                    alert.setContentText("You're trying to generate more passwords than there are words in the file!");

                    alert.showAndWait();
                }
            }
        }
    }
}
