package RUCafe;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class CurrentOrderDetailController {

    @FXML
    private TextArea subTotalCurrentOrder, salesTaxCurrentOrder, totalCurrentOrder;

    @FXML
    private Button RemoveSelectedItem, placeOrder;

    @FXML
    private ListView<String> currentOrderListView;

    /**
     *
     * @param infoDonuts
     * @param subTotal
     */
    public void displayOrders(ObservableList<String> infoDonuts, String subTotal){
        currentOrderListView.getItems().addAll(infoDonuts);
        subTotalCurrentOrder.setText(String.valueOf(subTotal));
    }

}
