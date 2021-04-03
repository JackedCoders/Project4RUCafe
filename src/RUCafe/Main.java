package RUCafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.lang.reflect.AnnotatedArrayType;

/**
 * Main class for our project, creates the stage and loads the primary GUI of the project (MainMenuView.fxml). The class
 * also contains the main method, runs the corresponding fxml files along with setting title for our stage and initializes
 * the scene.
 * @author Manveer Singh, Prasidh Sriram
 */
public class Main extends Application {

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenuView.fxml")) ;
            Scene s = new Scene(root, 600,450);
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.UTILITY); //disables maximize and minimize so user can not close of the GUI
            primaryStage.setScene(s);
            primaryStage.setTitle("Welcome to RU Cafe!!");
            primaryStage.show();
        } catch( Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
