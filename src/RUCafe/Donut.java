package RUCafe;

/**
 * Back end Donut class that directly handles all of the calculations, add, remove and assignments for our
 * DonutView and DonutController files. This class also has a toString that allows us to print the contents to store
 * order GUI at the end of placing orders.
 * @author Manveer Singh, Prasidh Sriram
 */
public class Donut extends MenuItem{

    final static double YEAST_DONUT_PRICE = 1.39;
    final static double CAKE_DONUT_PRICE = 1.59;
    final static double DONUT_HOLE_PRICE = 0.33;
    private int donutType; //0==yeast, 1==cake, 2==donut hole
    private String quantityOfDonut;
    private String donutName;
    private String donutFlavor;


    /**
     * setter method to assign this private instance var quantityOfDonut to parameter quantityOfDonut
     * @param quantityOfDonut # of donuts to add
     */
    public void setQuantityOfDonut(int quantityOfDonut) {

        this.quantityOfDonut = quantityOfDonut +"";
    }


    /**
     *
     * @return
     */
    public int getDonutType() {
        return donutType;
    }

    /**
     *
     */
    public Donut(){

    }
    /**
     * Donut class constructor to create a donut object
     * @param donutType either 0,1 or 2. 0 for Yeast, 1 for Cake, 2 for Donut Hole
     */
    public Donut(int donutType, String donutFlavor, String quantityDonut){
        this.donutType = donutType;
        this.donutFlavor = donutFlavor;
        this.quantityOfDonut = quantityDonut;
        if(donutType == 0){
            super.itemPrice(Integer.parseInt(quantityDonut)*YEAST_DONUT_PRICE);
        }if(donutType == 1){
            super.itemPrice(Integer.parseInt(quantityDonut)*CAKE_DONUT_PRICE);
        }if(donutType == 2){
            super.itemPrice(Integer.parseInt(quantityDonut)*DONUT_HOLE_PRICE);
        }

    }

    /**
     *
     * @param d
     */
    public Donut(Donut d){
        donutType = d.getDonutType();
        if(donutType == 0){
            super.itemPrice(YEAST_DONUT_PRICE);
        }if(donutType == 1){
            super.itemPrice(CAKE_DONUT_PRICE);
        }if(donutType == 2){
            super.itemPrice(DONUT_HOLE_PRICE);
        }
    }

    /**
     * Constructor with different parameter that assigns our private instance variable donutName to parameter donutName
     * @param donutName name of the donut
     */
    public Donut(String donutName){
        this.donutName = donutName;
    }

    /**
     * Returns itemPrice variable from our super class menuItem
     * @return price of the menuItem
     */
    public double itemPrice(){
        return super.getItemPrice();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String donutTypName ="";
        if(this.donutType ==0){
            donutTypName ="Yeast Donut";
        }else if(this.donutType ==1){
            donutTypName ="Cake Donut";
        }else if(this.donutType ==2){
            donutTypName ="Donut Hole";
        }
        return donutTypName + ", " + this.donutFlavor + "[" + this.quantityOfDonut + "]";
    }

}
