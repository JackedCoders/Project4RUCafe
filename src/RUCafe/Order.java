package RUCafe;

import java.util.ArrayList;

/**
 * Backend order class that adds and removes objects based on user input along with having the most
 * important arrayLIst of type MenuItem that holds all of the orders printed to the store orders.
 * Class also has a toString method used to return description of orders
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{
    public static int orderNum;
    private ArrayList<MenuItem> orderHolderArray = new ArrayList<>();

    /**
     * toString method that returns all of the contents of our arrayList above
     * @return full contents of array list orderHolderArray
     */
    public String toString(){
        String res ="";
        for(int i = 0; i<this.orderHolderArray.size(); i++){
            res += this.orderHolderArray.get(i).toString();
        }
        return res;
    }

    /**
     * Constructor that initializes order num to 1 so we can start off there and increment
     */
    public Order(){
        orderNum =1;
        this.orderHolderArray = new ArrayList<>();
    }

    /**
     * add method that overrides add in Customizable interface and adds objects to our arrayList
     * @param obj object we want to add
     * @return boolean true if successful
     */
    @Override
    public boolean add(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderHolderArray.add(item);
        return true;
    }

    /**
     * remove method that overrides add in Customizable interface and remove objects from our arrayList
     * @param obj object we want to remove
     * @return boolean true if successful
     */
    @Override
    public boolean remove(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderHolderArray.remove(item);
        return true;
    }

    /**
     * Getter method that returns the contents of our arraylist orderHolderArray of type MenuItem
     * @return
     */
    public ArrayList<MenuItem> getMenuItems(){
        return this.orderHolderArray;
    }
}
