package RUCafe;

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
    private ListView currentOrderListView;

}
