package RUCafe;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

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

    /**
     *
     * @param order
     */
    public void setOrder (Order order) {
        this.order = order;
    }

    /**
     *
     * @param storeOrder
     */
    public void setStoreOrder (StoreOrders storeOrder) {
        storeOrder = storeOrder;
    }

    /**
     *
     * @param subtotal
     */
    public void setSubTotal (double subtotal) {
        subTotalCurrentOrder.setText(subtotal + "");
    }

    /**
     *
     * @param salestax
     */
    public void setSalesTax (double salestax) {
        salesTaxCurrentOrder.setText(salestax + "");
    }

    /**
     *
     * @param finalTotal
     */
    public void setTotal (double finalTotal) {
        totalCurrentOrder.setText(finalTotal + "");
    }

    /**
     *
     */
    public void setItems() {
        currentOrderListView.setItems(DonutController.observableList);
    }

    /**
     *
     * @param event
     */
    @FXML
    void removeFromCurrentOrder(ActionEvent event){
        if(currentOrderListView.getSelectionModel().isEmpty()){
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Order needs to be added or selected before attempting to remove");
            showErrorNull.setTitle("Choose a valid order to remove!!");
            showErrorNull.showAndWait();
        }else{
            String nameOfDonut = currentOrderListView.getSelectionModel().getSelectedItem();
            currentOrderListView.getItems().remove(nameOfDonut);
            Alert showConfirmation = new Alert(Alert.AlertType.INFORMATION);
            showConfirmation.setContentText("Item has been removed from order.");
            showConfirmation.setTitle("Removal Confirmed");
            showConfirmation.show();
            if(currentOrderListView.getItems().isEmpty()){
                subTotalCurrentOrder.clear();
                totalCurrentOrder.clear();
                salesTaxCurrentOrder.clear();
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void placeOverallOrder(ActionEvent event){

    }

}
