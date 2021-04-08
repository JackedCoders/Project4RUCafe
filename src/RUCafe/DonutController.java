package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for our donut GUI (DonutView.fxml) which performs several different actions like
 * initializing donut types, donut flavors, adding specific donuts to the order and removing selected based on user
 * preference along with displaying the correct overall price of the order and a toString method to allow for export
 * @author Manveer Singh, Prasidh Sriram
 */
public class DonutController implements Initializable {

    @FXML
    private ListView<String> donutFlavorListView, donutAddedListView;

    @FXML
    private Button addToOrder, removeSelectedDonut, addOneSelectedDonut, addTwoSelectedDonuts, addThreeSelectedDonuts;

    @FXML
    private TextArea subTotalTextArea;

    @FXML
    private ComboBox<String> typeOfDonut;

    public static ObservableList<String> observableList = FXCollections.observableArrayList();
    private Order orderOBJ;
    double overallDonutOrderPrice =0;
    private final int YEAST_DONUT = 0;
    private final int CAKE_DONUT = 1; //also ADD_ONE
    private final int DONUT_HOLE = 2; //also ADD_TWO
    private final int ADD_THREE = 3;
    private Donut newDonut;
    private String donutTypeString;
    

    /**
     * This method populates the combo boxes with the type of donuts and the amount a user wants in that order to be added to the cart
     * using observableLists of type string. automatically populates upon running the GUI
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> typeOfDonutList = FXCollections.observableArrayList("Yeast Donut" , "Cake Donut" , "Donut Hole");
        typeOfDonut.setItems(typeOfDonutList);
        subTotalTextArea.setText("0.00");
        addToOrder.setDisable(true);
    }

    /**
     * Reference allocation to be able to transfer data between controllers and GUIs
     * @param order object passed
     */
    public void setOrderController(Order order){
        orderOBJ = order;
    }


    /**
     * This method populates the type of donut List View on our GUI with the flavors that are chosen.
     * Note that this method includes at least 3 flavors for each donutType
     * @param event
     */
    @FXML
    void fillListViewLeft(ActionEvent event){
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Cake Donut")){
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Lemon");
            donutFlavorListView.getItems().add("Orange");
            donutFlavorListView.getItems().add("Vanilla");
        } else if(getSelection.equals("Yeast Donut")){
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Powdered");
            donutFlavorListView.getItems().add("Apple Fritter");
            donutFlavorListView.getItems().add("Jelly Filled");
        }else if(getSelection.equals("Donut Hole")){
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Sour Cream");
            donutFlavorListView.getItems().add("Sugar");
            donutFlavorListView.getItems().add("Boston Kreme");
        }
    }

    /**
     *  Method to allow the user to remove donuts selected on a listView along with displaying invalid occurence messages
     *  and displaying current overall cost of the order thus far.
     * @param mouseEvent
     */
    @FXML
    void removeSelectedDonutRightListView(javafx.scene.input.MouseEvent mouseEvent) {
        String name = donutAddedListView.getSelectionModel().getSelectedItem();
        if(name == null){
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("No donut was selected! Select a donut to remove");
            showErrorNull.setTitle("Try again");
            showErrorNull.showAndWait();
        }else{
                String typeOfDonut = name.substring(0,name.indexOf(","));
                int donutQuantity = Integer.parseInt(name.substring(name.indexOf("[") + 1, name.indexOf("]")));
                if(typeOfDonut.equals("Yeast Donut")){
                    overallDonutOrderPrice -= Donut.YEAST_DONUT_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }else if(typeOfDonut.equals("Cake Donut")){
                    overallDonutOrderPrice -= Donut.CAKE_DONUT_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }else if(typeOfDonut.equals("Donut Hole")){
                    overallDonutOrderPrice -= Donut.DONUT_HOLE_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }
        }
        if(donutAddedListView.getItems().isEmpty()){
            subTotalTextArea.setText("0.00");
            overallDonutOrderPrice = 0;
        }
    }

    /**
     * Helper method that avoids duplicate code and assigns correct prices, creates new donut objects and
     * updates subtotal everytime there is a new order
     * @param x number of donuts to add (either 1, 2 or 3)
     */
    private void helpAddingDonutToOrder(int x){
        String nameOfDonut = donutFlavorListView.getSelectionModel().getSelectedItem();
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(nameOfDonut == null){
            //throw null errors here I think
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Donut selection & flavor is required before quantity can be chosen");
            showErrorNull.setTitle("Choose donut first & Try Again");
            showErrorNull.showAndWait();
        }else{
            if(typeOfDonut.getSelectionModel().getSelectedItem().toString().equals("Yeast Donut")){
                newDonut = new Donut(0, nameOfDonut, x+"");
            }
            if(typeOfDonut.getSelectionModel().getSelectedItem().toString().equals("Cake Donut")){
                newDonut = new Donut(1, nameOfDonut, x+"");
            }
            if(typeOfDonut.getSelectionModel().getSelectedItem().toString().equals("Donut Hole")){
                newDonut = new Donut(2, nameOfDonut, x+"");
            }
            System.out.println(x);
            newDonut.setQuantityOfDonut(x);
            overallDonutOrderPrice += newDonut.itemPrice();
            String s = String.format("%.02f", overallDonutOrderPrice);
            subTotalTextArea.setText(String.valueOf(s));
            donutAddedListView.getItems().add(getSelection + ", " + nameOfDonut + "[" + x + "]");
            addToOrder.setDisable(false);
        }
    }

    /**
     * Helper method that throws an error alert of type WARNING in certain situations used throughout this class
     */
    private void helpThrowErorrNull(){
        Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
        showErrorNull.setContentText("Donut selection & flavor is required before adding");
        showErrorNull.setTitle("Choose donut first & Try Again");
        showErrorNull.showAndWait();
    }

    /**
     * FXML method to add ONE donut to the selected list view of orders.
     * If selected, add. If listview is empty, throw error
     * @param event
     */
    @FXML
    void addOneDonutToOrder(ActionEvent event){
        if(donutFlavorListView.getItems().isEmpty()){
            helpThrowErorrNull();
        }else {
            helpAddingDonutToOrder(CAKE_DONUT);
        }
    }

    /**
     * FXML method to add TWO donuts to the selected list view of orders.
     * If selected, add. If listview is empty, throw error
     * @param event
     */
    @FXML
    void addOTwoDonutToOrder(ActionEvent event){
        if(donutFlavorListView.getItems().isEmpty()){
            helpThrowErorrNull();
        }else {
            helpAddingDonutToOrder(DONUT_HOLE);
        }
    }



    /**
     * FXML method to add THREE donuts to the selected list view of orders.
     * If selected, add. If listview is empty, throw error
     * @param event
     */
    @FXML
    void addOThreeDonutToOrder(ActionEvent event){
        if(donutFlavorListView.getItems().isEmpty()){
            helpThrowErorrNull();
        }else {
            helpAddingDonutToOrder(ADD_THREE);
        }
    }

    /**
     *Identify the type of donut we're dealing with and then based on that create a new donut object
     * that gets added
     * @param donut string name of donut
     * @return object to add later on
     */
    public Donut identityType(String donut){
        Donut newDonutToAdd = new Donut();
        String getSelection = donut.substring(0, donut.indexOf(","));
        String flavor = donut.substring(donut.indexOf(",")+2, donut.indexOf("["));
        String quantity = donut.substring(donut.indexOf("[")+1, donut.indexOf("]"));
        if(getSelection.equals("Yeast Donut")){
            newDonutToAdd = new Donut(0,flavor,quantity);
        }else if (getSelection.equals("Cake Donut")){
            newDonutToAdd = new Donut(1,flavor,quantity);
        }else if(getSelection.equals("Donut Hole")){
            newDonutToAdd = new Donut(2,flavor,quantity);
        }
        return newDonutToAdd;
    }

    /**
     * FXML button method that adds the entire donut order to the current order GUI and also takes care of certain cases
     * and shows Alert messages when need be
     * @param event
     */
    @FXML
    public void addDonutOrder(ActionEvent event){
       if(donutAddedListView.getItems().isEmpty()){
           Alert newAlert = new Alert(Alert.AlertType.ERROR);
           newAlert.setTitle("Invalid order to add!");
           newAlert.setContentText("You must select the type of donut, the flavor and the quantity to add the donut order");
           newAlert.showAndWait();
       }else {
           ObservableList<String> listItems = donutAddedListView.getItems();
           for(int i =0; i<listItems.size();i++){
               observableList.add(listItems.get(i));
               Donut picked = identityType(listItems.get(i));
               orderOBJ.add(picked);
           }
           Alert newAlert = new Alert(Alert.AlertType.CONFIRMATION);
           newAlert.setTitle("Order added to cart!!");
           newAlert.setContentText("Order has been added. You may close this window to view your order");
           newAlert.showAndWait();
       }

    }


}
