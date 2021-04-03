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
    String donutName;

    /**
     *
     * @param donutType
     */
    public Donut(int donutType){
        this.donutType = donutType;
        if(donutType == 0){
            super.itemPrice(YEAST_DONUT_PRICE);
        }if(donutType == 1){
            super.itemPrice(CAKE_DONUT_PRICE);
        }if(donutType == 2){
            super.itemPrice(DONUT_HOLE_PRICE);
        }

    }

    /**
     *
     * @return
     */
    public double getItemPrice(){
        return super.getItemPrice();
    }


    /**
     *
     * @return
     */
    public void itemPrice(){
        if(donutType == 0){
            itemPrice = YEAST_DONUT_PRICE;
        }if(donutType == 1){
            itemPrice = CAKE_DONUT_PRICE;
        }if(donutType == 2){
            itemPrice = DONUT_HOLE_PRICE;
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
