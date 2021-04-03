package RUCafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the primary MainMenu GUI that is the backbone of this project. Class directly loads other
 * GUIs such as Coffee, Donut, View current orders and overall store orders. This class also allows us to keep the
 * main GUI visible at all times
 * @author Manveer Singh, Prasidh Sriram
 */
public class MainMenuController {

    @FXML
    private Button OrderDonutsButton, OrderCoffeeButton, ViewStoreOrdersButton, ViewYourOrderButton;


    /**
     * FXML method that loads the Coffee ordering GUI (OrderingCoffeeView.fxml) and sets the stage so
     * the user can directly order coffee
     * @param event
     * @throws IOException
     */
    @FXML
    private void openCoffeeOrdering(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("OrderingCoffeeView.fxml"));
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("Order Coffee here!!");
        root_stage.show();
    }

    /**
     * FXML method that loads the Donut ordering GUI (OrderingDonutView.fxml) and sets the stage so
     * the user can directly order donut(s)(types and flavors)
     * @param event
     * @throws IOException
     */
    @FXML
    private void openDonutOrdering(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("Order Donut here!!");
        root_stage.show();
    }

    /**
     * FXML method that loads the overall store orders GUI (StoreOrdersView.fxml) and sets the stage so
     * we can see all the orders the cafe has received
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewAllStoreOrders(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("StoreOrdersView.fxml"));
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("All of store orders here!!");
        root_stage.show();
    }

    /**
     * FXML method that loads the current order details (CurrentOrderDetailView.fxml) and sets the stage so
     * we can view the current orders being placed by the user
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewYourCurrentOrder(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("CurrentOrderDetailView.fxml"));
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("Your current order!!");
        root_stage.show();
    }
}
