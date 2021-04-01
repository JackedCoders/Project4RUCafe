package RUCafe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreOrdersController {
    @FXML
    private Button cancelSelectedOrder, exportOrders;

    @FXML
    private ComboBox orderNumberCombobox;

    @FXML
    private TextField totalForSelectedOrderTxtField;

    @FXML
    private ListView ListOfOrderListView;


}
