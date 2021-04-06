package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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

    private final int CoffeeSizeShort =0;
    private final int CoffeeSizeTall =1; //also quantity 1
    private final int CoffeeSizeGrande =2; //also quantity 2
    private final int CoffeeSizeVenti =3; //also quantity 3
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
        resetEverything.setDisable(true);
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            resetEverything.setDisable(false);
        }else{
            newCoffee.remove(Milk);
            newCoffee.addIn.remove("Milk");
            String s = String.format("%.02f", newCoffee.itemPrice());
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            resetEverything.setDisable(false);

        }else{
            newCoffee.remove(Syrup);
            newCoffee.addIn.remove("Syrup");
            String s = String.format("%.02f", newCoffee.itemPrice());
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            resetEverything.setDisable(false);
        }else{
            newCoffee.remove(Caramel);
            newCoffee.addIn.remove("Caramel");
            String s = String.format("%.02f", newCoffee.itemPrice());
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            resetEverything.setDisable(false);
        }else{
            newCoffee.remove(Cream);
            newCoffee.addIn.remove("Cream");
            String s = String.format("%.02f", newCoffee.itemPrice());
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            resetEverything.setDisable(false);
        }else{
            newCoffee.remove(WhippedCream);
            newCoffee.addIn.remove("Whipped Cream");
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }
    }


    /**
     *
     */
    private void helpSetSizesProperties(){
        String s = String.format("%.02f", newCoffee.itemPrice());
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
        resetEverything.setDisable(false);
    }
    /**
     *
     * @param event
     */
    @FXML
    void sizesCalculation(ActionEvent event){
//        private final int CoffeeSizeShort =0;
//        private final int CoffeeSizeTall =1;
//        private final int CoffeeSizeGrande =2;
//        private final int CoffeeSizeVenti =3;
        String getSelection = coffeeSize.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Short")){
            newCoffee = new Coffee(CoffeeSizeShort);
            helpSetSizesProperties();
        }else if(getSelection.equals("Tall")){
            newCoffee = new Coffee(CoffeeSizeTall);
            helpSetSizesProperties();
        }else if(getSelection.equals("Grande")){
            newCoffee = new Coffee(CoffeeSizeGrande);
            helpSetSizesProperties();
        }else if(getSelection.equals("Venti")){
            newCoffee = new Coffee(CoffeeSizeVenti);
            helpSetSizesProperties();
        }
    }

    /**
     *
     * @param x
     */
    private void helpSetQuantityProperties(int x){
        String s = String.format("%.02f", (x * newCoffee.itemPrice()));
        subtotalAreaTextArea.setText(String.valueOf(s));
        newCoffee.quantityKeepTrack =x;
        Milk.setDisable(true);
        Syrup.setDisable(true);
        Caramel.setDisable(true);
        Cream.setDisable(true);
        WhippedCream.setDisable(true);
        coffeeSize.setDisable(true);
        resetEverything.setDisable(false);
    }
    /**
     *
     * @param event
     */
    @FXML
    void quantityCalculation(ActionEvent event){
        String getSelectionQuantity = quantityOfCoffee.getSelectionModel().getSelectedItem().toString();
       if(getSelectionQuantity.equals("1")){
            helpSetQuantityProperties(CoffeeSizeTall);
        }else if(getSelectionQuantity.equals("2")){
           helpSetQuantityProperties(CoffeeSizeGrande);
        }else if(getSelectionQuantity.equals("3")){
           helpSetQuantityProperties(CoffeeSizeVenti);
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
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Tall")){
            newCoffee.itemPrice = newCoffee.TALL_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Grande")){
            newCoffee.itemPrice = newCoffee.GRANDE_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }else if(getSelection.equals("Venti")){
            newCoffee.itemPrice = newCoffee.VENTI_COFFEE_PRICE;
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void addToOrderCoffee(ActionEvent event){

    }



}
