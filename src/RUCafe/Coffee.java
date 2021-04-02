package RUCafe;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Coffee extends MenuItem implements Customizable{

    final double COST_PER_ADDIN = 0.2;
    final double SHORT_COFFEE_PRICE = 1.99;
    final double TALL_COFFEE_PRICE = 2.49;
    final double GRANDE_COFFEE_PRICE = 2.99;
    final double VENTI_COFFEE_PRICE = 3.49;

    private int coffeeSize; //0 == short, 1 == tall, 2 ==grande, 3 == venti
    private int numAddIns;

    /**
     *
     * @return
     */
    public void itemPrice(){
        if(coffeeSize == 0){
            super.itemPrice(COST_PER_ADDIN*numAddIns + SHORT_COFFEE_PRICE);
        }if(coffeeSize == 1){
            super.itemPrice(COST_PER_ADDIN*numAddIns + TALL_COFFEE_PRICE);
        }if(coffeeSize == 2){
            super.itemPrice(COST_PER_ADDIN*numAddIns + GRANDE_COFFEE_PRICE);
        }if(coffeeSize == 3){
            super.itemPrice(COST_PER_ADDIN*numAddIns + VENTI_COFFEE_PRICE);
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
