package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class CoffeeController implements Initializable {

    @FXML
    private CheckBox Milk, Syrup, Caramel, Cream, WhippedCream;

    @FXML
    private TextArea subtotalAreaTextArea;

    @FXML
    private Button addToOrder, resetEverything;

    @FXML
    private ComboBox<String> coffeeSize;

    @FXML
    private ComboBox<Integer> quantityOfCoffee;


    Coffee newCoffee = new Coffee(0);
    Order newOrder = new Order();
    StoreOrders newTotalOrder = new StoreOrders();

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        ObservableList<String> coffeeSizeList = FXCollections.observableArrayList("Short" , "Tall" , "Grande", "Venti");
        ObservableList<Integer> coffeeQuantityList = FXCollections.observableArrayList(1,2,3);
        coffeeSize.setItems(coffeeSizeList);
        quantityOfCoffee.setItems(coffeeQuantityList);
        Milk.setDisable(true);
        Milk.setSelected(false);
        Syrup.setDisable(true);
        Syrup.setSelected(false);
        Cream.setDisable(true);
        Cream.setSelected(false);
        Caramel.setDisable(true);
        Caramel.setSelected(false);
        WhippedCream.setDisable(true);
        WhippedCream.setSelected(false);
    }

    /**s
     *
     * @param event
     */
    @FXML
    void addToppingMilk(ActionEvent event){
        if(Milk.isSelected()){
            newCoffee.add(Milk);
            newCoffee.addIn.add("Milk");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else{
            newCoffee.remove(Milk);
            newCoffee.addIn.remove("Milk");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
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
            newCoffee.addIn.add("Syrup");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));

        }else{
            newCoffee.remove(Syrup);
            newCoffee.addIn.remove("Syrup");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
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
            newCoffee.addIn.add("Caramel");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else{
            newCoffee.remove(Caramel);
            newCoffee.addIn.remove("Caramel");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
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
            newCoffee.addIn.add("Cream");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else{
            newCoffee.remove(Cream);
            newCoffee.addIn.remove("Cream");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
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
            newCoffee.addIn.add("Whipped Cream");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else{
            newCoffee.remove(WhippedCream);
            newCoffee.addIn.remove("Whipped Cream");
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void sizesCalculation(ActionEvent event){
        String getSelection = coffeeSize.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Short")){
            newCoffee = new Coffee(0);
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            Milk.setDisable(false);
            Milk.setSelected(false);
            Syrup.setDisable(false);
            Syrup.setSelected(false);
            Cream.setDisable(false);
            Cream.setSelected(false);
            Caramel.setDisable(false);
            Caramel.setSelected(false);
            WhippedCream.setDisable(false);
            WhippedCream.setSelected(false);
        }else if(getSelection.equals("Tall")){
            newCoffee = new Coffee(1);
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            Milk.setDisable(false);
            Milk.setSelected(false);
            Syrup.setDisable(false);
            Syrup.setSelected(false);
            Cream.setDisable(false);
            Cream.setSelected(false);
            Caramel.setDisable(false);
            Caramel.setSelected(false);
            WhippedCream.setDisable(false);
            WhippedCream.setSelected(false);
        }else if(getSelection.equals("Grande")){
            newCoffee = new Coffee(2);
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            Milk.setDisable(false);
            Milk.setSelected(false);
            Syrup.setDisable(false);
            Syrup.setSelected(false);
            Cream.setDisable(false);
            Cream.setSelected(false);
            Caramel.setDisable(false);
            Caramel.setSelected(false);
            WhippedCream.setDisable(false);
            WhippedCream.setSelected(false);
        }else if(getSelection.equals("Venti")){
            newCoffee = new Coffee(3);
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            Milk.setDisable(false);
            Milk.setSelected(false);
            Syrup.setDisable(false);
            Syrup.setSelected(false);
            Cream.setDisable(false);
            Cream.setSelected(false);
            Caramel.setDisable(false);
            Caramel.setSelected(false);
            WhippedCream.setDisable(false);
            WhippedCream.setSelected(false);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void quantityCalculation(ActionEvent event){
        String getSelectionQuantity = quantityOfCoffee.getSelectionModel().getSelectedItem().toString();
       if(getSelectionQuantity.equals("1")){
            newCoffee.quantityKeepTrack =1;
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            Milk.setDisable(true);
            Syrup.setDisable(true);
            Caramel.setDisable(true);
            Cream.setDisable(true);
            WhippedCream.setDisable(true);
            coffeeSize.setDisable(true);
        }else if(getSelectionQuantity.equals("2")){
           newCoffee.quantityKeepTrack =2;
           String s = String.format("%.02f", (newCoffee.getItemPrice()*2));
           subtotalAreaTextArea.setText(String.valueOf(s));
           Milk.setDisable(true);
           Syrup.setDisable(true);
           Caramel.setDisable(true);
           Cream.setDisable(true);
           WhippedCream.setDisable(true);
           coffeeSize.setDisable(true);
        }else if(getSelectionQuantity.equals("3")){
           newCoffee.quantityKeepTrack =3;
           String s = String.format("%.02f", (newCoffee.getItemPrice()*3));
           subtotalAreaTextArea.setText(String.valueOf(s));
           Milk.setDisable(true);
           Syrup.setDisable(true);
           Caramel.setDisable(true);
           Cream.setDisable(true);
           WhippedCream.setDisable(true);
           coffeeSize.setDisable(true);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void resetEverythingGUI(ActionEvent event){
        Milk.setDisable(false);
        Milk.setSelected(false);
        Syrup.setDisable(false);
        Syrup.setSelected(false);
        Cream.setDisable(false);
        Cream.setSelected(false);
        Caramel.setDisable(false);
        Caramel.setSelected(false);
        WhippedCream.setDisable(false);
        WhippedCream.setSelected(false);
        subtotalAreaTextArea.clear();
        coffeeSize.setDisable(false);
        quantityOfCoffee.setDisable(false);
        String getSelection = coffeeSize.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Short")){
            newCoffee.itemPrice = newCoffee.SHORT_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Tall")){
            newCoffee.itemPrice = newCoffee.TALL_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Grande")){
            newCoffee.itemPrice = newCoffee.GRANDE_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Venti")){
            newCoffee.itemPrice = newCoffee.VENTI_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.getItemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }
    }



}
