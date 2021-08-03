

public class Order {

  private int combo1Count;
  private int combo2Count;
  private int original;
  private int superSmoothie;
  private int duperSmoothie;
  private int scone;

  /**
   * Create a Order at (1,#combs*1 ,1)
   */
  public Order() {
    original = 1;
    scone = combo1Count * 1;
    //combo1Count = 1;

  }
  /**
   * Create a Order with the given comboConut
   * @param combo1Count the comb#1
   * @param combo2Count the comb#2
   */

  public Order(int combo1Count, int combo2Count) {
    if (combo1Count == 0 && combo2Count == 0) {
      throw new IllegalArgumentException(" All shouldn't be 0");

    }
    if (combo1Count < 0 || combo2Count < 0) {
      throw new IllegalArgumentException("Order cannot be negative");

    }

    this.combo1Count = combo1Count;
    this.combo2Count = combo2Count;

    original = combo1Count * 1;

   

    duperSmoothie = combo2Count * 1;

  }
  /**
   * Create a Order with the given type of smoothies
   * @param original the originaSmoothie
   * @param superSmoothie the SupuerSmoothie
   * @param duperSmoothie the duperSmoothie
   * @param scones the scones
   */
  public Order(int original, int superSmoothie, int duperSmoothie, int scone) {
    //Throws an IllegalArgumentException for invalid arguments all 0s
    if (original == 0 && superSmoothie == 0 && duperSmoothie == 0 && scone == 0) {
      throw new IllegalArgumentException("All Order Can't be Zero");

    }
    //Throws an IllegalArgumentException for invalid arguments negative values
    if (original < 0 || superSmoothie < 0 || duperSmoothie < 0 || scone < 0) {
      throw new IllegalArgumentException("Order cannot be negative");

    }
    this.original = original;
    this.superSmoothie = superSmoothie;
    this.duperSmoothie = duperSmoothie;
    this.scone = scone;

  }
  
  /**
   * Gets total order of original smoothie made.
   * @return the number of original smoothies in this Order
   * */
  int getOriginalCount() {

    return original;
  }
  /**
   * Gets total order of super smoothie made.
   * @return the number of Super smoothies in this Order
   * */
  
  int getSuperSmoothieCount() {
    return superSmoothie;
  }
  /**
   * Gets total order of duper smoothie made.
   * @return the number of duper smoothies in this Order
   * */
  
  int getDuperSmoothieCount() {

    return duperSmoothie;
  }
  /**
   * Gets total order of scones  made.
   * @return the number of  scones in this Order
   * */
   
  int getSconeCount() {

    return this.scone;
  }
  /**
   * Gets if the order has a combo.
   * @return if the order has a Combo 
   * */
   
  boolean hasCombo() {

    if (combo1Count > 0 || combo2Count > 0) {
      //System.out.println("contains combo");
      return true;
    }
    return false;
  }
  
  public void test() {
	// TODO Auto-generated method stub
	  Order comb1 = new Order();
      Order combos = new Order(4,2);
      Order regularSmoothie = new Order(1,2,3,4);
      System.out.println("Comb #1"+comb1.combo1Count); // displaying comb1 
      System.out.println(combos.combo2Count); //   displaying comb2
      System.out.println(combos.combo1Count); //   displaying comb1
      
      
      System.out.println(regularSmoothie.getOriginalCount()); //   displaying original smoothie
      System.out.println(regularSmoothie.getSuperSmoothieCount()); //   displaying super smoothie
      System.out.println(regularSmoothie.getDuperSmoothieCount()); //   displaying duper smoothie
      System.out.println(regularSmoothie.scone); // dispplay number of scones

}
}