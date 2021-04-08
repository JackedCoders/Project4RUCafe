package RUCafe;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private StoreOrders allOrders = new StoreOrders();
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

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void exportAllStoreOrders(ActionEvent event) throws IOException {
        //should be same as project 3
        ObservableList<String> allOrders = ListOfOrderListView.getItems();
            FileChooser chooser = new FileChooser();
            chooser.setTitle("Open Target File for the Export");
            chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("All Files", "*.*"));
            Stage stage = new Stage();
            File fileLocation = chooser.showSaveDialog(stage); //get where you want to save the file, think now we add code to write the file
            //catch all exceptions..
            try{
                FileWriter fileWriter = new FileWriter(fileLocation);
                for(int i =0; i<allOrders.size(); i++){
                    fileWriter.write(allOrders.get(i) + "\n"); //goes through every element of allOrders String and writes it to the file
                }
                fileWriter.close();
            }catch(NullPointerException e){
                Alert nullError = new Alert(Alert.AlertType.WARNING);
                nullError.setTitle("Export Cancelled");
                nullError.setContentText("Please click on Export and try again!!");
                nullError.showAndWait();
                return;
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    void cancelSelectedOrderFromStoreOrders(ActionEvent event){
            if(ListOfOrderListView.getSelectionModel().isEmpty()){
                Alert emptyError = new Alert(Alert.AlertType.WARNING);
                emptyError.setContentText("Add or select the order you want to cancel");
                emptyError.setTitle("No Order Selected to Cancel");
                emptyError.showAndWait();
            }else{
                String orderToCancel = ListOfOrderListView.getSelectionModel().getSelectedItem();
                ListOfOrderListView.getItems().remove(orderToCancel);
            }
    }



}
