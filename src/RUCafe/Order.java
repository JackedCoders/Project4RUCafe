package RUCafe;
/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Order implements Customizable{

    private int order_ID; //Unique number assigned to each order
    private MenuItem [] itemList;

    public int getOrder_ID(){
        return order_ID;
    }

    public Order(){
        itemList = new MenuItem[5];
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
