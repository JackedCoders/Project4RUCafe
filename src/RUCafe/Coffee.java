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

    public int quantityKeepTrack;
    public static final int SHORT_COFFEE = 0;
    public static final int TALL_COFFEE = 1;
    public static final int GRANDE_COFFEE = 2;
    public static final int VENTI_COFFEE = 3;
    ArrayList<String> addIn = new ArrayList<>();

    /**
     *
     * @param sizeOfCoffee
     */
    public Coffee(int sizeOfCoffee){
        if(sizeOfCoffee ==0){
            super.itemPrice = SHORT_COFFEE_PRICE;
        }else if(sizeOfCoffee ==1){
            super.itemPrice = TALL_COFFEE_PRICE;
        }else if(sizeOfCoffee ==2){
            super.itemPrice = GRANDE_COFFEE_PRICE;
        }else if(sizeOfCoffee ==3){
            super.itemPrice = VENTI_COFFEE_PRICE;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public double getItemPrice(){
        return super.getItemPrice();
    }

    /**
     *
     * @param obj
     * @return
     */
    public boolean add(Object obj){
        super.itemPrice  = itemPrice + COST_PER_ADDIN;
        return false;
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
