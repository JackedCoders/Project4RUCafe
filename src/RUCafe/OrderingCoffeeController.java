package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> orderSize = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        ObservableList<String> quantitySize = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        coffeeOrderSize.setItems(orderSize);
        coffeeOrderQuantity.setItems(quantitySize);
    }
}
