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

    void grow(){
        Order [] newList = new Order[numOrders + 5];
        for(int i = 0; i < numOrders; i++){
            newList[i] = orderList[i];
        }
        orderList = newList;
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
        numOrders++;
        return true;
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
