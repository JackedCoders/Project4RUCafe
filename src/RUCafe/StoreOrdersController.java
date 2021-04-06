package RUCafe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private TextArea totalForSelectedOrderTxtField;

    @FXML
    private ListView<String> ListOfOrderListView;
    StoreOrders allOrders = new StoreOrders();
    private Order orderOBJ;

    public void setTotal(double total){
        totalForSelectedOrderTxtField.setText(Double.toString(total));
    }

    public void setItems(){
        ListOfOrderListView.setItems(DonutController.observableList);
    }

    public void setOrderController(Order order){
        orderOBJ = order;
    }

    @FXML
    void cancelSelectedOrderFromStoreOrders(ActionEvent event){

    }



}
