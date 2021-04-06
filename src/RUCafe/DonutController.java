package RUCafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for our donut GUI (DonutView.fxml) which performs several different actions like
 * initializing donut types, donut flavors, adding specific donuts to the order and removing selected based on user
 * preference along with displaying the correct overall price of the order and a toString method to allow for export
 * @author Manveer Singh, Prasidh Sriram
 */
public class DonutController implements Initializable {

    @FXML
    private ListView<String> donutFlavorListView, donutAddedListView;

    @FXML
    private Button addToOrder, removeSelectedDonut, addOneSelectedDonut, addTwoSelectedDonuts, addThreeSelectedDonuts;

    @FXML
    private TextArea subTotalTextArea;

    @FXML
    private ComboBox<String> typeOfDonut;

    public static ObservableList<String> observableList = FXCollections.observableArrayList();
    private Order orderOBJ;
    double overallDonutOrderPrice =0;
    private int yeastDonut = 0;
    private int cakeDonut = 1;
    private int donutHole = 2;
    Donut newDonut = new Donut(yeastDonut);
    private String donutTypeString;

    /**
     * This method populates the comboboxes with the type of donuts and the amount a user wants in that order to be added to the cart
     * using observableLists of type string. automatically populates upon running the GUI
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> typeOfDonutList = FXCollections.observableArrayList("Yeast Donut" , "Cake Donut" , "Donut Hole");
        typeOfDonut.setItems(typeOfDonutList);
        subTotalTextArea.setText("0.00");
    }

    /**
     *
     * @param order
     */
    public void setOrderController(Order order){
        orderOBJ = order;
    }


    /**
     * This method populates the type of donut List View on our GUI with the flavors that are chosen.
     * Note that this method includes at least 3 flavors for each donutType
     * @param event
     */
    @FXML
    void fillListViewLeft(ActionEvent event){
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Cake Donut")){
            newDonut = new Donut(cakeDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Lemon");
            donutFlavorListView.getItems().add("Orange");
            donutFlavorListView.getItems().add("Vanilla");
        } else if(getSelection.equals("Yeast Donut")){
            newDonut = new Donut(yeastDonut);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Powdered");
            donutFlavorListView.getItems().add("Apple Fritter");
            donutFlavorListView.getItems().add("Jelly Filled");
        }else if(getSelection.equals("Donut Hole")){
            newDonut = new Donut(donutHole);
            donutFlavorListView.getItems().clear();
            donutFlavorListView.getItems().add("Sour Cream");
            donutFlavorListView.getItems().add("Sugar");
            donutFlavorListView.getItems().add("Boston Kreme");
        }
    }

    /**
     *  Method to allow the user to remove donuts selected on a listView along with displaying invalid occurence messages
     *  and displaying current overall cost of the order thus far.
     * @param mouseEvent
     */
    @FXML
    void removeSelectedDonutRightListView(javafx.scene.input.MouseEvent mouseEvent) {
        String name = donutAddedListView.getSelectionModel().getSelectedItem();
        if(name == null){
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("No donut was selected! Select a donut to remove");
            showErrorNull.setTitle("Try again");
            showErrorNull.showAndWait();
        }else{
                String typeOfDonut = name.substring(0,name.indexOf(","));
                int donutQuantity = Integer.parseInt(name.substring(name.indexOf("[") + 1, name.indexOf("]")));
                if(typeOfDonut.equals("Yeast Donut")){
                    overallDonutOrderPrice -= Donut.YEAST_DONUT_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }else if(typeOfDonut.equals("Cake Donut")){
                    overallDonutOrderPrice -= Donut.CAKE_DONUT_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }else if(typeOfDonut.equals("Donut Hole")){
                    overallDonutOrderPrice -= Donut.DONUT_HOLE_PRICE*donutQuantity;
                    String s = String.format("%.02f", overallDonutOrderPrice);
                    donutAddedListView.getItems().remove(name);
                    subTotalTextArea.setText(s);
                }
        }
        if(donutAddedListView.getItems().isEmpty()){
            subTotalTextArea.setText("0.00");
            overallDonutOrderPrice = 0;
        }
    }

    /**
     *
     * @param x number of donuts to add (either 1, 2 or 3)
     */
    private void helpAddingDonutToOrder(int x){
        String nameOfDonut = donutFlavorListView.getSelectionModel().getSelectedItem();
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(nameOfDonut == null){
            //throw null errors here I think
            Alert showErrorNull = new Alert(Alert.AlertType.WARNING);
            showErrorNull.setContentText("Donut selection & flavor is required before quantity can be chosen");
            showErrorNull.setTitle("Choose donut first & Try Again");
            showErrorNull.showAndWait();
        }else{
            newDonut.setQuantityOfDonut(x);
            overallDonutOrderPrice += (x*newDonut.itemPrice());
            String s = String.format("%.02f", overallDonutOrderPrice);
            subTotalTextArea.setText(String.valueOf(s));
            donutAddedListView.getItems().add( getSelection + ", " + nameOfDonut + "[" + x + "]");
            addToOrder.setDisable(false);
        }
    }
    /**
     *
     * @param event
     */
    @FXML
    void addOneDonutToOrder(ActionEvent event){
        helpAddingDonutToOrder(1);
    }

    /**
     *
     * @param event
     */
    @FXML
    void addOTwoDonutToOrder(ActionEvent event){
        helpAddingDonutToOrder(2);
    }



    /**
     *
     * @param event
     */
    @FXML
    void addOThreeDonutToOrder(ActionEvent event){
        helpAddingDonutToOrder(3);
    }

    /**
     *
     * @param donut
     * @return
     */
    public Donut identityType(String donut){
        String getSelection = typeOfDonut.getSelectionModel().getSelectedItem().toString();
        if(getSelection.equals("Yeast Donut")){
            donutTypeString ="Yeast Donut";
        }else if (getSelection.equals("Cake Donut")){
            donutTypeString ="Cake Donut";
        }else if(getSelection.equals("Donut Hole")){
            donutTypeString = "Donut Hole";
        }
        Donut donutToAdd = new Donut(getSelection);
        return donutToAdd;
    }
    /**
     *
     * @param event
     */
    @FXML
    public void addDonutOrder(ActionEvent event){
      ObservableList<String> listItems = donutAddedListView.getItems();
      orderOBJ.orderList.add(newDonut);
      for(int i =0; i<listItems.size();i++){
          observableList.add(listItems.get(i));
          Donut picked = identityType(listItems.get(i));
          orderOBJ.add(picked);
      }
    }


}
