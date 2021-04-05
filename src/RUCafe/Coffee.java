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

    int quantityKeepTrack;
    int shortCoffee =0;
    int tallCoffee =1;
    int grandeCoffee =2;
    int ventiCoffee =3;
    ArrayList<String> addIn = new ArrayList<>();

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
