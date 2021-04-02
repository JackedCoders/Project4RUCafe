package RUCafe;
/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Donut extends MenuItem implements Customizable{

    final double YEAST_DONUT_PRICE = 1.39;
    final double CAKE_DONUT_PRICE = 1.59;
    final double DONUT_HOLE_PRICE = 0.33;

    private int donutType; //0==yeast, 1==cake, 2==donut hole
    
    public

    /**
     *
     * @return
     */
    public void itemPrice(){
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
