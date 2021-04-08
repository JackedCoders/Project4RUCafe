package RUCafe;

import java.util.ArrayList;

/**
 * Back end Coffee class that directly handles all of the calculations, add, remove and assignments for our
 * CoffeeView and CoffeeController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
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
     * Constructor of this class that allows for identification of coffee prices and type based on the integer assigned
     * 0 for short, 1 for tall, 2 for grande, 3 for venti
     * @param sizeOfCoffee is the integer that gets passed in and used to assign values
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
     * getter method to return itemPrice from MenuItem.java
     * @return returns the contents of getItemPrice() method in our super class MenuItem
     */
    public double itemPrice(){
        return super.getItemPrice();
    }

    /**
     * Adds any addins that we might have for our coffee order.
     * Notice that this method also overrides the add method in customizable interface
     * @param obj name of the add-in
     * @return
     */
    @Override
    public boolean add(Object obj){
        super.itemPrice = itemPrice + COST_PER_ADDIN;
        return false;
    }

    /**
     * toString method that prints a short description of the coffee order so far
     * @return string concatenated with Price, quantity and quantity
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
     * Removes any addins from the coffee object and overrides the remove method in
     * customizable interface
     * @param obj
     * @return name of the add-in
     */
    @Override
    public boolean remove(Object obj){
        super.itemPrice = itemPrice - COST_PER_ADDIN;
        return false;
    }
}
