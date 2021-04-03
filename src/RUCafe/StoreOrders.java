package RUCafe;
/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class StoreOrders implements Customizable{

    private Order [] orderList;
    private int numOrders;

    public StoreOrders(){
        orderList = new Order[5];
        numOrders = 0;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean add(Object obj) {
        Order newOrder = (Order) obj;
        orderList[numOrders] = newOrder;
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
