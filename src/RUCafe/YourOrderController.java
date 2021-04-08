package RUCafe;

import javafx.collections.FXCollections;
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
    public static ObservableList<String> passCurrToStore = FXCollections.observableArrayList();
    private double subTotal;
    private double salesTax;
    private double total;

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
        this.storeOrder = storeOrder;
    }

    /**
     *
     * @param subtotal
     */
    public void setSubTotal (double subtotal) {
        String subTotalString = String.format("%.02f", subtotal);
        subTotalCurrentOrder.setText(subTotalString + ".");
    }

    /**
     *
     * @param salestax
     */
    public void setSalesTax (double salestax) {
        String salestaxString = String.format("%.02f", salestax);
        salesTaxCurrentOrder.setText(salestaxString + ".");
    }

    /**
     *
     * @param finalTotal
     */
    public void setTotal (double finalTotal) {
        String finalTotalString = String.format("%.02f", finalTotal);
        totalCurrentOrder.setText(finalTotalString + ".");
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
            for(MenuItem item_inlist: order.getMenuItems()) {
                System.out.println(item_inlist.toString());
                if(item_inlist.toString().equals(nameOfDonut)) {
                 subTotal = Integer.parseInt(subTotalCurrentOrder.getText())- item_inlist.getItemPrice();
                 System.out.println(Integer.parseInt(subTotalCurrentOrder.getText()));
                }
            }
            salesTax = subTotal * MainMenuController.SALES_TAX_RATE;
            total = subTotal + salesTax;
            subTotalCurrentOrder.setText(subTotal+"");
            salesTaxCurrentOrder.setText(salesTax + "");
            totalCurrentOrder.setText(total+"");
            Alert showConfirmation = new Alert(Alert.AlertType.INFORMATION);
            showConfirmation.setContentText("Item has been removed from order.");
            showConfirmation.setTitle("Removal Confirmed");
            showConfirmation.show();
        }

        if(currentOrderListView.getItems().isEmpty()){
            subTotalCurrentOrder.clear();
            totalCurrentOrder.clear();
            totalCurrentOrder.clear();
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void placeOverallOrder(ActionEvent event){
        if(currentOrderListView.getItems() == null || currentOrderListView.getItems().isEmpty()) {
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("No items found to be added. Add orders to place orders");
            showErrorNull.setTitle("Try again");
            showErrorNull.showAndWait();
        }
        else {
            Alert showErrorNull = new Alert(Alert.AlertType.CONFIRMATION);
            showErrorNull.setContentText("Congrats! Order Placed");
            showErrorNull.setTitle("Order another one?");
            showErrorNull.showAndWait();
            StoreOrdersController.appendOrderNUm.add(StoreOrdersController.num_of_order++);
            Order deepcopy = new Order(order);
            storeOrder.add(deepcopy);
        }
    }

}
