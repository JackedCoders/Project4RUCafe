package RUCafe;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private MenuButton sizeOfDrink, quantityOfCoffee;

    Coffee newCoffee = new Coffee();
    Order newOrder = new Order();
    StoreOrders newTotalOrder = new StoreOrders();

    /**
     *
     * @param event
     */
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

    /**
     *
     * @param event
     */
    @FXML
    void addToppingSyrup(ActionEvent event){
        if(Syrup.isSelected()){
            newCoffee.add(Syrup);
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

    /**
     *
     * @param event
     */
    @FXML
    void addToppingCaramel(ActionEvent event){
        if(Caramel.isSelected()){
            newCoffee.add(Caramel);
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

    /**
     *
     * @param event
     */
    @FXML
    void addToppingCream(ActionEvent event){
        if(Cream.isSelected()){
            newCoffee.add(Cream);
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

    /**
     *
     * @param event
     */
    @FXML
    void addToppingWhippedCream(ActionEvent event){
        if(WhippedCream.isSelected()){
            newCoffee.add(WhippedCream);
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
