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
import java.util.StringTokenizer;

/**
 * Controller class for CoffeeView.fxml file that implements all of the functionality seen on the front end of our project.
 * Handles everything from adding, removing, selecting, customizing, initializing our Coffee GUI. Direct handler
 * and controller of Coffee part of the project along with displaying the correct overall price of the order and a toString method to
 * allow for export
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

    @FXML
    private ListView<String> addToCurrentOrderListView;

    private final int COFFEE_SIZE_SHORT =0;
    private final int COFFEE_SIZE_TALL =1; //also quantity 1
    private final int COFFEE_SIZE_GRANDE =2; //also quantity 2
    private final int COFFEE_SIZE_VENTI =3; //also quantity 3
    private Coffee newCoffee = new Coffee(0);
    private Order order;
    final private ObservableList<String> COFFEE_SIZE_LIST = FXCollections.observableArrayList("Short" , "Tall" , "Grande", "Venti");
    final private ObservableList<Integer> COFFEE_QUANTITY_LIST = FXCollections.observableArrayList(1,2,3);

    /**
     * Method that fully initializes the CoffeeGUI so it's ready to be used, also initialises the flavors
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        coffeeSize.setItems(COFFEE_SIZE_LIST);
        quantityOfCoffee.setItems(COFFEE_QUANTITY_LIST);
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
        quantityOfCoffee.setDisable(true); //added just now
        subtotalAreaTextArea.setDisable(true);
        addToOrder.setDisable(true);
    }

    /**
     *  FXML method that adds the addin "Milk" to the coffee object and performs price calculations
     *  if deselected, simply remove from the subtotal
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
     *  FXML method that adds the addin "Syrup" to the coffee object and performs price calculations
     *  if deselected, simply remove from the subtotal
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
     *  FXML method that adds the addin "Caramel" to the coffee object and performs price calculations
     *  if deselected, simply remove from the subtotal
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
     *  FXML method that adds the addin "Cream" to the coffee object and performs price calculations
     *  if deselected, simply remove from the subtotal
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
     *  FXML method that adds the addin "Whipped Cream" to the coffee object and performs price calculations
     *  if deselected, simply remove from the subtotal
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
     * Helper method that avoids duplicate code and sets certain properties (buttons, check boxes, etc) disable when need be
     */
    private void helpSetSizesProperties(){
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
        quantityOfCoffee.setDisable(false);
        addToOrder.setDisable(false);
    }
    /**
     * Method that performs calculations for our coffee order based on it's size and short being the smallest of them
     * all. Method adds the price to the subtotal text area
     * @param event
     */
    @FXML
    void sizesCalculation(ActionEvent event){
        String getSelection = coffeeSize.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Short")){
            newCoffee = new Coffee(COFFEE_SIZE_SHORT);
            resetEverything.setDisable(false);
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            helpSetSizesProperties();
        }else if(getSelection.equals("Tall")){
            newCoffee = new Coffee(COFFEE_SIZE_TALL);
            resetEverything.setDisable(false);
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            helpSetSizesProperties();
        }else if(getSelection.equals("Grande")){
            newCoffee = new Coffee(COFFEE_SIZE_GRANDE);
            resetEverything.setDisable(false);
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            helpSetSizesProperties();
        }else if(getSelection.equals("Venti")){
            newCoffee = new Coffee(COFFEE_SIZE_VENTI);
            resetEverything.setDisable(false);
            String s = String.format("%.02f", newCoffee.itemPrice());
            subtotalAreaTextArea.setText(String.valueOf(s));
            helpSetSizesProperties();
        }
    }

    /**
     * Helper method that gets rids of duplicate code and helps in calculating the correct price for
     * our coffee order
     * @param x quantity of coffees ordered
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
     * Method that calculates the correct price for coffee order based on quantity, 1, 2 or 3
     * @param event
     */
    @FXML
    void quantityCalculation(ActionEvent event){
        String getSelectionQuantity = quantityOfCoffee.getSelectionModel().getSelectedItem().toString();
       if(getSelectionQuantity.equals("1")){
            helpSetQuantityProperties(COFFEE_SIZE_TALL);
           addToOrder.setDisable(false);
        }else if(getSelectionQuantity.equals("2")){
           helpSetQuantityProperties(COFFEE_SIZE_GRANDE);
           addToOrder.setDisable(false);
        }else if(getSelectionQuantity.equals("3")){
           helpSetQuantityProperties(COFFEE_SIZE_VENTI);
           addToOrder.setDisable(false);
        }
    }

    /**
     * Additional feature of the GUI that allows the user to reset every property in the GUI and start a
     * fresh order
     * @param event
     */
    @FXML
    void resetEverythingGUI(ActionEvent event){
        helpSetSizesProperties();
        subtotalAreaTextArea.clear();
        coffeeSize.setDisable(false);
        addToCurrentOrderListView.getItems().clear();
        subtotalAreaTextArea.clear();
        quantityOfCoffee.setItems(COFFEE_QUANTITY_LIST);
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
     *  Creates a new coffee object based on the string passed in, based on size too
     * @param coffee String to compare
     * @return a new object to add to our arrayList
     */
    public Coffee createCoffeeObject(String coffee){
        String coffeeSizeString = coffeeSize.getValue().toString();
        int coffeeSizeInt = 0;
        if(coffeeSizeString == "Short"){
            coffeeSizeInt = COFFEE_SIZE_SHORT;
        }else if(coffeeSizeString == "Tall"){
            coffeeSizeInt = COFFEE_SIZE_TALL;
        }else if(coffeeSizeString == "Grande"){
            coffeeSizeInt = COFFEE_SIZE_GRANDE;
        }else if(coffeeSizeString == "Venti"){
            coffeeSizeInt = COFFEE_SIZE_VENTI;
        }
        Coffee newCoffeeBasedOnSize = new Coffee(coffeeSizeInt);
        return newCoffeeBasedOnSize;
    }

    /**
     * FXML button method that adds selected coffee addins, size and flavor to current order GUI and
     * handles several different scenarios to ensure the program does not fail
     * @param event
     */
    @FXML
    void addToOrderCoffee(ActionEvent event){
        if(quantityOfCoffee.getValue() == null){
            Alert empError = new Alert(Alert.AlertType.ERROR);
            empError.setTitle("Invalid Quantity! Try again");
            empError.setContentText("Quantity must be selected before adding to order! ");
            empError.showAndWait();
        }else{
            String quantityToAdd = quantityOfCoffee.getValue().toString();
            String coffeeSizeToAdd = coffeeSize.getValue().toString();
            String AddOns = "";

            if(Milk.isSelected() ){
                AddOns += " Milk ";
            }
            if(Caramel.isSelected() ){
                AddOns += " Caramel ";
            }
            if(WhippedCream.isSelected() ){
                AddOns += " Whipped Cream ";
            }
            if(Syrup.isSelected()){
                AddOns += " Syrup ";
            }
            if(Cream.isSelected()){
                AddOns += " Cream ";
            }
            if(!Cream.isSelected() && !Caramel.isSelected() && !WhippedCream.isSelected() && !Syrup.isSelected() && !Milk.isSelected()){
                AddOns += "None";
            }

            String s = String.format("%.02f", newCoffee.itemPrice);
            addToCurrentOrderListView.getItems().add("Size: " + coffeeSizeToAdd + " , Quantity: " + quantityToAdd + " , Price $" + subtotalAreaTextArea.getText() +" , Addons: " + AddOns);
            ObservableList<String> currentOrderFinallist = addToCurrentOrderListView.getItems();
            for (String value : currentOrderFinallist) {
                DonutController.observableList.add(value);
                Coffee newPicked = createCoffeeObject(value);
                order.add(newPicked);
            }
        }


    }



}
