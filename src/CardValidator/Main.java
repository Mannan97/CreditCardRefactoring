package CardValidator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CreditCardRefactor.fxml"));
        //primaryStage.setTitle("Credit");
        primaryStage.setScene(new Scene(root, 351, 175));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}