import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    bombCreate bombCreate= new bombCreate();

    ArrayList<KeyCode>keyCodeArrayList=new ArrayList<>();

    public static Stage stage;

    ObservableList<Screen> screens = Screen.getScreens();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader myLoader = new FXMLLoader();
        myLoader.setLocation(this.getClass().getResource("view.fxml"));
        Parent root = myLoader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.setTitle("WPE");
        primaryStage.show();
        primaryStage.requestFocus();

    primaryStage.setOnCloseRequest(this::handle);
        this.stage = primaryStage;


        VBox VBoxForTest = new VBox();
        VBoxForTest.setMaxSize(0, 0);
        Scene scene = new Scene(VBoxForTest);
        keyCodeArrayList = bombCreate.getBomby();
        scene.setOnKeyPressed( (KeyEvent event) -> {
            if(event.getCode() == keyCodeArrayList.get(0) || event.getCode() ==  keyCodeArrayList.get(1) || event.getCode() == keyCodeArrayList.get(2) || event.getCode() ==  keyCodeArrayList.get(3) ){
                try {
                    Runtime.getRuntime().exec("shutdown -f");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Key Pressed: " + event.getCode());
        });

    primaryStage.setScene(scene);
    primaryStage.show();

    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public void handle(WindowEvent event) {
        Platform.exit();
        System.exit(0);
    }








}





