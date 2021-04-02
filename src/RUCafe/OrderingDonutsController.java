package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> typeOfDonut = FXCollections.observableArrayList("Yeast Donut" , "Cake Donut" , "Donut Holes");
        ObservableList<String> quantityOfDonut = FXCollections.observableArrayList("1" , "2", "3" );
        
    }

}
