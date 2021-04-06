package RUCafe;

import java.util.ArrayList;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{
    public static int orderNum;
    ArrayList<MenuItem> orderList;

    public Order(){
        orderNum =1;
        this.orderList = new ArrayList<>();
    }

    public boolean add(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderList.add(item);
        return true;
    }

    public boolean remove(Object obj){
        MenuItem item = (MenuItem) obj;
        this.orderList.remove(item);
        return true;
    }

    public ArrayList<MenuItem> getMenuItems(){
        return this.orderList;
    }

    public String toString(){
        String res ="";
        for(int i =0; i<this.orderList.size(); i++){
            res += this.orderList.get(i).toString();
        }
        return res;
    }

}
