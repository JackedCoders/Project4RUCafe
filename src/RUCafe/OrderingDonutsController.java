package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javax.print.CancelablePrintJob;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderingDonutsController implements Initializable {

    @FXML
    private ListView<String> donutFlavorListView, donutAddedListView;

    @FXML
    private Button addToOrder, removeSelectedDonut;

    @FXML
    private TextArea subTotalTextArea;

    @FXML
    private ComboBox<String> typeOfDonut, quantityOfDonut;

    private int yeastDonut = 0;
    private int cakeDonut = 1;
    private int donutHole = 2;
    Donut newDonut = new Donut(0);
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
        ObservableList<String> quantityOfDonutList = FXCollections.observableArrayList("1" , "2", "3" );
        typeOfDonut.setItems(typeOfDonutList);
        quantityOfDonut.setItems(quantityOfDonutList);
    }

    /**
     * This method populates the type of donut List View on our GUI with the flavors that are chosen.
     * Note that this method includes at least 3 flavors for each donutType 
     * @param event
     */
    @FXML
    void fillListViewLeft(ActionEvent event){
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(getSelection == "Cake Donut"){
            newDonut = new Donut(cakeDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Lemon");
            donutFlavorListView.getItems().add("Orange");
            donutFlavorListView.getItems().add("Vanilla");
        } else if(getSelection == "Yeast Donut"){
            newDonut = new Donut(yeastDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Powdered");
            donutFlavorListView.getItems().add("Apple Fritter");
            donutFlavorListView.getItems().add("Jelly Filled");
        }else if(getSelection == "Donut Hole"){
            newDonut = new Donut(donutHole);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Sour Cream");
            donutFlavorListView.getItems().add("Sugar");
            donutFlavorListView.getItems().add("Boston Kreme");
        }
    }

}
