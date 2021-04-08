package RUCafe;

import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{
    public static int orderNum;
    ArrayList<MenuItem> orderHolderArray;

    public String toString(){
        String res ="";
        for(int i = 0; i<this.orderHolderArray.size(); i++){
            res += this.orderHolderArray.get(i).toString();
        }
        return res;
    }
    public Order(){
        orderNum =1;
        this.orderHolderArray = new ArrayList<>();
    }

    public boolean add(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderHolderArray.add(item);
        return true;
    }

    public boolean remove(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderHolderArray.remove(item);
        return true;
    }

    public ArrayList<MenuItem> getMenuItems(){
        return this.orderHolderArray;
    }



}
