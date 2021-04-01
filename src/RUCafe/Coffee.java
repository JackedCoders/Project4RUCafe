package RUCafe;

/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Coffee extends MenuItem implements Customizable{

    final double SHORT_COFFEE_PRICE = 1.99;
    final double TALL_COFFEE_PRICE = 2.49;
    final double GRANDE_COFFEE_PRICE = 2.99;
    final double VENTI_COFFEE_PRICE = 3.49;

    /**
     *
     * @return
     */
    public double itemPrice(){
        return 0;
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
