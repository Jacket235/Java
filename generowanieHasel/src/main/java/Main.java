import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static Stage stage;
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader myLoader = new FXMLLoader();
        myLoader.setLocation(this.getClass().getResource("view.fxml"));
        Parent root = myLoader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setTitle("PASSWORD GENERATOR");
        primaryStage.show();
        primaryStage.requestFocus();
        primaryStage.setOnCloseRequest(this::handle);
        this.stage = primaryStage;
    }
    public void handle(WindowEvent event) {
        Platform.exit();
        System.exit(0);
    }
    public static void main(String[] args) throws Exception{
        launch(args);
    }
}