package RUCafe;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class YourOrderController {

    @FXML
    private TextArea subTotalCurrentOrder, salesTaxCurrentOrder, totalCurrentOrder;

    @FXML
    private Button RemoveSelectedItem, placeOrder;

    @FXML
    private ListView<String> currentOrderListView;

    private StoreOrders storeOrder;
    private Order order;

    /**
     *
     * @param order
     */
    public void setOrderController(Order order){
        this.order = order;
    }

    public void setOrder (Order order) {
        this.order = order;
    }

    public void setStoreOrder (StoreOrders storeOrder) {
        storeOrder = storeOrder;
    }

    public void setSubTotal (double subtotal) {
        subTotalCurrentOrder.setText(subtotal + "");
    }

    public void setSalesTax (double salestax) {
        salesTaxCurrentOrder.setText(salestax + "");
    }

    public void setTotal (double finalTotal) {
        totalCurrentOrder.setText(finalTotal + "");
    }

    public void setItems() {
        currentOrderListView.setItems(DonutController.observableList);
    }

}
