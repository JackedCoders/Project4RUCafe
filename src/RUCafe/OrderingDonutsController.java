package RUCafe;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import javax.print.CancelablePrintJob;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class OrderingDonutsController {

    String typeDonuts[] = {"Yeast Donut", "Cake Donut", "Donut Hole"};
    @FXML
    ChoiceBox  typeDonutsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(typeDonuts));


}
