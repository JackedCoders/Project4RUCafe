package RUCafe;
/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{

    private int order_ID; //Unique number assigned to each order

    public int getOrder_ID(){
        return order_ID;
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
