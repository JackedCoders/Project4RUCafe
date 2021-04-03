package RUCafe;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderingCoffeeController {

    @FXML
    private CheckBox Milk, Syrup, Caramel, Cream, WhippedCream;

    @FXML
    private TextArea textArea;

    @FXML
    private Button addToOrder;

    @FXML
    private ComboBox coffeeOrderSize, coffeeOrderQuantity;

    Coffee newCoffee = new Coffee();
    Order newOrder = new Order();
    StoreOrders newTotalOrder = new StoreOrders();
    
    @FXML
    void addToppingMilk(ActionEvent event){
        if(Milk.isSelected()){
            newCoffee.add(Milk);
            newCoffee.addTopping();
            newCoffee.itemPrice();
            String s = String.format("%.02f", newCoffee.getItemPrice());
            textArea.setText(String.valueOf(s));

        }else{
            newCoffee.removeTopping();
            newCoffee.itemPrice();
            String s = String.format("%.02f", newCoffee.getItemPrice());
            textArea.setText(String.valueOf(s));

        }
    }

}
