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
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class MainMenuController {

    @FXML
    private Button OrderDonutsButton, OrderCoffeeButton, ViewStoreOrdersButton, ViewYourOrderButton;


    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void openCoffeeOrdering(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("OrderingCoffeeView.fxml"));
        Scene root_scene = new Scene(root_parent);
        Stage root_stage = new Stage();
        root_stage.setScene(root_scene);
        root_stage.setTitle("Order Coffee here!!");
        root_stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void openDonutOrdering(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        Scene root_scene = new Scene(root_parent);
        Stage root_stage = new Stage();
        root_stage.setScene(root_scene);
        root_stage.setTitle("Order Donut here!!");
        root_stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewAllStoreOrders(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("StoreOrdersView.fxml"));
        Scene root_scene = new Scene(root_parent);
        Stage root_stage = new Stage();
        root_stage.setScene(root_scene);
        root_stage.setTitle("All of store orders here!!");
        root_stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewYourCurrentOrder(ActionEvent event) throws IOException{
        Parent root_parent = FXMLLoader.load(getClass().getResource("CurrentOrderDetailView.fxml"));
        Scene root_scene = new Scene(root_parent);
        Stage root_stage = new Stage();
        root_stage.setScene(root_scene);
        root_stage.setTitle("Your current order!!");
        root_stage.show();
    }
}
