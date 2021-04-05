package RUCafe;

/**
 * MenuItem class is considered to be the parent class of all sub classes in the project (donuts, coffee etc)
 * Every class that is related to our mainMenu GUI must extend this class
 * itemPrice is protected so that we can access it in Donut and Coffee classes
 * @author Manveer Singh, Prasidh Sriram
 */
public class MenuItem {

    protected double itemPrice;

    /**
     *
     * @param itemPrice
     */
    public void itemPrice(double itemPrice){
        this.itemPrice = itemPrice;
    }

    /**
     * getter method that returns the protected instance variable itemPrice of this class
     * when called in other classes
     * @return itemPrice
     */
    public double getItemPrice(){
        return this.itemPrice;
    }

    /**
     * ToString method that will help with exporting the orders at the end of the order placing
     * @return the string which contains all of the orders
     */
    public String toString(){
        String r = super.toString();
        r += "Menu Item";
        return r;
    }
}
