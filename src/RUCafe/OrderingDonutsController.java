package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javax.print.CancelablePrintJob;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for our donut GUI (OrderingDonutsView.fxml) which performs several different actions like
 * initializing donut types, donut flavors, adding specific donuts to the order and removing selected based on user
 * preference along with displaying the correct overall price of the order and a toString method to allow for export
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderingDonutsController implements Initializable {

    @FXML
    private ListView<String> donutFlavorListView, donutAddedListView;

    @FXML
    private Button addToOrder, removeSelectedDonut, addOneSelectedDonut, addTwoSelectedDonuts, addThreeSelectedDonuts;

    @FXML
    private TextArea subTotalTextArea;

    @FXML
    private ComboBox<String> typeOfDonut;

    double overallDonutOrderPrice =0;
    private int yeastDonut = 0;
    private int cakeDonut = 1;
    private int donutHole = 2;
    Donut newDonut = new Donut(yeastDonut);
    Order newOrder = new Order();
    Alert neAlert = new Alert(Alert.AlertType.WARNING);

    /**
     * This method populates the comboboxes with the type of donuts and the amount a user wants in that order to be added to the cart
     * using observableLists of type string. automatically populates upon running the GUI
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> typeOfDonutList = FXCollections.observableArrayList("Yeast Donut" , "Cake Donut" , "Donut Hole");
        typeOfDonut.setItems(typeOfDonutList);
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
            newDonut = new Donut(cakeDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Lemon");
            donutFlavorListView.getItems().add("Orange");
            donutFlavorListView.getItems().add("Vanilla");
        } else if(getSelection.equals("Yeast Donut")){
            newDonut = new Donut(yeastDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Powdered");
            donutFlavorListView.getItems().add("Apple Fritter");
            donutFlavorListView.getItems().add("Jelly Filled");
        }else if(getSelection.equals("Donut Hole")){
            newDonut = new Donut(donutHole);
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
            donutAddedListView.getItems().remove(name);
            String s = String.format("%.02f", newDonut.getItemPrice());
            subTotalTextArea.setText(String.valueOf(s));
        }

        if(donutAddedListView.getItems().isEmpty()){
            subTotalTextArea.clear();
            overallDonutOrderPrice = 0;
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void addOneDonutToOrder(ActionEvent event){
        String nameOfDonut = donutFlavorListView.getSelectionModel().getSelectedItem();
        if(nameOfDonut == null){
            //throw null errors here I think
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Donut selection & flavor is required before quantity can be chosen");
            showErrorNull.setTitle("Choose donut first & Try Again");
            showErrorNull.showAndWait();
        }else{
            newDonut.quantityOfDonut = 1;
            overallDonutOrderPrice += newDonut.getItemPrice();
            String s = String.format("%.02f", overallDonutOrderPrice);
            subTotalTextArea.setText(String.valueOf(s));
            donutAddedListView.getItems().add(nameOfDonut + "[1]");
            addToOrder.setDisable(false);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void addOTwoDonutToOrder(ActionEvent event){
        String nameOfDonut = donutFlavorListView.getSelectionModel().getSelectedItem();
        if(nameOfDonut.equals(null)){
            //throw null errors here I think
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Donut selection & flavor is required before quantity can be chosen");
            showErrorNull.setTitle("Choose donut first & Try Again");
            showErrorNull.showAndWait();
        }else{
            newDonut.quantityOfDonut = 2;
            overallDonutOrderPrice += (2*newDonut.getItemPrice());
            String s = String.format("%.02f", overallDonutOrderPrice);
            subTotalTextArea.setText(String.valueOf(s));
            donutAddedListView.getItems().add(nameOfDonut + "[2]");
            addToOrder.setDisable(false);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void addOThreeDonutToOrder(ActionEvent event){
        String nameOfDonut = donutFlavorListView.getSelectionModel().getSelectedItem();
        if(nameOfDonut.equals(null)){
            //throw null errors here I think
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Donut selection & flavor is required before quantity can be chosen");
            showErrorNull.setTitle("Choose donut first & Try Again");
            showErrorNull.showAndWait();
        }else{
            newDonut.quantityOfDonut = 3;
            overallDonutOrderPrice += (3*newDonut.getItemPrice());
            String s = String.format("%.02f", overallDonutOrderPrice);
            subTotalTextArea.setText(String.valueOf(s));
            donutAddedListView.getItems().add(nameOfDonut + "[3]");
            addToOrder.setDisable(false);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void addToFinalOrder(MouseEvent event) throws IOException {
        FXMLLoader sendOrder = new FXMLLoader(getClass().getResource("CurrentOrderDetailView.fxml"));
        Parent root = sendOrder.load();
        CurrentOrderDetailController newOrder = sendOrder.getController();

        //COME BACK TO THIS ADD ORDER TO BACK PART

    }


}
