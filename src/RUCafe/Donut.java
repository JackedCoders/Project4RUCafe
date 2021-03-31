package RUCafe;
/**
 *
 * @author Manveer Singh, Prasidh Sriram
 */
public class Donut extends MenuItem implements Customizable{

    final double YEAST_DONUT_PRICE = 1.39;
    final double CAKE_DONUT_PRICE = 1.59;
    final double DONUT_HOLE_PRICE = 0.33;

    public double itemPrice(){
        return 0;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
