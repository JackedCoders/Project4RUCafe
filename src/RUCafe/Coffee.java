package RUCafe;

import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Coffee extends MenuItem implements Customizable{

    final double COST_PER_ADDIN = 0.20;
    final double SHORT_COFFEE_PRICE = 1.99;
    final double TALL_COFFEE_PRICE = 2.49;
    final double GRANDE_COFFEE_PRICE = 2.99;
    final double VENTI_COFFEE_PRICE = 3.49;

    public static int quantityKeepTrack; //to be able to set it in other controllers and display in toString
    public static final int SHORT_COFFEE = 0;
    public static final int TALL_COFFEE = 1;
    public static final int GRANDE_COFFEE = 2;
    public static final int VENTI_COFFEE = 3;
    protected ArrayList<String> addIn = new ArrayList<>();
    private String nameOfSize;

    /**
     *
     * @param sizeOfCoffee
     */
    public Coffee(int sizeOfCoffee){
        if(sizeOfCoffee == SHORT_COFFEE){
            super.itemPrice = SHORT_COFFEE_PRICE;
            this.nameOfSize = "Short Size";
        }else if(sizeOfCoffee ==TALL_COFFEE){
            super.itemPrice = TALL_COFFEE_PRICE;
            this.nameOfSize= "Tall Size";
        }else if(sizeOfCoffee ==GRANDE_COFFEE){
            super.itemPrice = GRANDE_COFFEE_PRICE;
            this.nameOfSize = "Grande Size";
        }else if(sizeOfCoffee == VENTI_COFFEE){
            super.itemPrice = VENTI_COFFEE_PRICE;
            this.nameOfSize = "Venti Size";
        }
    }

    /**
     *
     * @return
     */
    public double itemPrice(){
        return super.getItemPrice();
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean add(Object obj){
        super.itemPrice = itemPrice + COST_PER_ADDIN;
        return false;
    }

    /**
     *
     * @return
     */
    public String toString(){
        String coffeeOrder = super.toString();
        coffeeOrder += "Size Of Coffee" + this.nameOfSize + ": Selected Addons ->";
        for(int i =0; i<this.addIn.size(); i++){
            coffeeOrder += addIn.get(i) + ", ";
        }
        String s = String.format("%.02f", this.itemPrice);
        coffeeOrder += "Price: " + s + ", " + "Quantity: " + this.quantityKeepTrack;
        return coffeeOrder;
    }
    /**
     *
     * @param obj
     * @return
     */
    public boolean remove(Object obj){
        super.itemPrice = itemPrice - COST_PER_ADDIN;
        return false;
    }
}
