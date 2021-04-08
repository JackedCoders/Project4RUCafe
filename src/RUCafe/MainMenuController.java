package RUCafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class for the primary MainMenu GUI that is the backbone of this project. Class directly loads other
 * GUIs such as Coffee, Donut, View current orders and overall store orders. This class also allows us to keep the
 * main GUI visible at all times
 * @author Manveer Singh, Prasidh Sriram
 */
public class MainMenuController{
    private StoreOrders storeOrders = new StoreOrders();
    private Order order = new Order();

    @FXML
    private Button OrderDonutsButton, OrderCoffeeButton, ViewStoreOrdersButton, ViewYourOrderButton;


    /**
     * FXML method that loads the Coffee ordering GUI (CoffeeView.fxml) and sets the stage so
     * the user can directly order coffee
     * @param event
     * @throws IOException
     */
    @FXML
    private void openCoffeeOrdering(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CoffeeView.fxml"));
        Parent root_parent = (Parent) fxmlLoader.load();
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.initModality(Modality.WINDOW_MODAL);
        root_stage.initOwner(Main.parentStage);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonutView.fxml"));
        Parent root_parent = (Parent) fxmlLoader.load();
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();
        root_stage.initModality(Modality.WINDOW_MODAL);
        root_stage.initOwner(Main.parentStage);
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("Order Donut here!!");
        root_stage.show();

        DonutController donutsController = fxmlLoader.getController();
        donutsController.setOrderController(this.order);
    }

    /**
     * FXML method that loads the overall store orders GUI (StoreOrdersView.fxml) and sets the stage so
     * we can see all the orders the cafe has received
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewAllStoreOrders(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent root_parent = (Parent) fxmlLoader.load();
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();

        root_stage.initModality(Modality.WINDOW_MODAL);
        root_stage.initOwner(Main.parentStage);
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("All of store orders here!!");
        root_stage.show();

    }

    /**
     * FXML method that loads the current order details (YourOrderView.fxml) and sets the stage so
     * we can view the current orders being placed by the user
     * @param event
     * @throws IOException
     */
    @FXML
    private void viewYourCurrentOrder(ActionEvent event) throws IOException{
        double subtotal =0;
        for(MenuItem item : order.getMenuItems()){
            subtotal += item.getItemPrice();
        }
        double tax = 0.06625;
        double salestax = subtotal * tax;
        double total = salestax + subtotal;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("YourOrderView.fxml"));
        Parent root_parent = (Parent) fxmlLoader.load();
        Scene root_scene = new Scene(root_parent,600, 450);
        Stage root_stage = new Stage();

        YourOrderController yourOrder = fxmlLoader.getController();
        yourOrder.setSubTotal(Double.parseDouble(String.format("%.02f", subtotal)));
        yourOrder.setSalesTax(Double.parseDouble(String.format("%.02f", salestax)));
        yourOrder.setTotal(Double.parseDouble(String.format("%.02f", total)));
        yourOrder.setItems();

        root_stage.initModality(Modality.WINDOW_MODAL);
        root_stage.initOwner(Main.parentStage);
        root_stage.resizableProperty().setValue(false);
        root_stage.setScene(root_scene);
        root_stage.setTitle("Your current order!!");
        root_stage.show();

        yourOrder.setOrder(this.order);
        yourOrder.setStoreOrder(this.storeOrders);
    }
}
