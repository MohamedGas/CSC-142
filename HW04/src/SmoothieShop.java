public class SmoothieShop {
  

  private int frozenBerries;
  private int greekYogurt;
  private int milk;
  private int scones;
  private int cups;
  private double totalSales;
  private double numberOfSales;
  private double costOfOrder = 0.0;
  /**
   * Create a SmoothieShop at (1000, 200,8000,500,2000,0)
   */
  public SmoothieShop() {
    frozenBerries = 1000;
    greekYogurt = 200;
    milk = 8000;
    scones = 500;
    cups = 2000;
    totalSales = 0.0;
  }
  /**
   * Get the totalSales of the orders.
   * @return the totalSales
   */

  double getTotalSales() {
    return totalSales;
  }
  /**
   * Get the averagCost of the orders.
   * @return the Average Cost 
   */
  double getAve() {
    if (totalSales!=0 && costOfOrder!=0)
    {
    	numberOfSales= costOfOrder/totalSales;
    }
    numberOfSales=0;
    return numberOfSales;

  }
  /**
   * Get the current state of the SmoothieShope
   * @return the String that represents the current state of the SmoothieShope 
   */
  public String toString() {
    String currentState = " frozenBerries : " + frozenBerries + " \n" + " greekYogurt : " +
      greekYogurt + " \n" + " milk : " + milk + " \n" + " scones : " + scones + "\n " +
      "cups : " + cups;
    return currentState;
  }

  /** Get the number of frozen berries in inventory
   * @return the number of frozen berries in inventory*/
  int getBerries() {
    return frozenBerries;
  }
  /** Get the number of greekYogurt in inventory
   * @return the number of greekYogurt  in inventory*/
  int getYogurt() {
    return greekYogurt;
  }
  /** Get the number of  cups in inventory
   * @return the number of cups  in inventory*/
  int getCups() {
    return cups;
  }
  /** Get the ounces of milk in inventory
   * @return the ounces of milk  in inventory*/
  int getMilk() {
    return milk;
  }
  /** Get the number of scones in inventory
   * @return the number of scones  in inventory*/
  int getScones() {
    return scones;

  }
  /** process the given Order by updating the inventory and total sales of this SmoothieShop
   * @param anOrder the anOrder Order
   * @return the price for this order
   */

  double processOrder(Order anOrder) {
    if (frozenBerries > 0) {
      String message = "------Your Order------\n ";

      int originalCount = anOrder.getOriginalCount();
      int superSmoothieCount = anOrder.getSuperSmoothieCount();
      int duperSmoothieCount = anOrder.getDuperSmoothieCount();
      int sconeCount = anOrder.getSconeCount();

      anOrder.hasCombo();

      double orgPrice = 4.99;
      double supSmoothiePrice = 5.49;
      double duperSmoothiePrice = 6.09;
      double sconePrice = 3.50;

      System.out.println(message);
      totalSales = originalCount + superSmoothieCount + duperSmoothieCount;
      costOfOrder = (originalCount * orgPrice) + (superSmoothieCount * supSmoothiePrice) +
        (duperSmoothieCount * duperSmoothiePrice);

      //if the order is originalSmoothie
      if (originalCount > 0 && anOrder.hasCombo() == false) {
        System.out.println("Original Smoothie : " + originalCount + "\t-- $" + originalCount * orgPrice);

        frozenBerries -= 4; // updating frozen berries
        milk -= 8; // updating milks
        cups -= 1; // updating number of cups in stock
      }

      //if the order is SuperSmoothie
      if (superSmoothieCount > 0 && anOrder.hasCombo() == false) {
        System.out.println("Super Smoothie :" + superSmoothieCount + "\t-- $" + superSmoothieCount * supSmoothiePrice);

        frozenBerries -= 4; // updating frozen berries
        greekYogurt -= 2; // updating greekYoogurt
        milk -= 8; // updating milks
        cups -= 1; // updating number of cups in stock
      }
      //if the order is DuperSmoothie
      if (duperSmoothieCount > 0 && anOrder.hasCombo() == false) {
        System.out.println("Duper Smoothie :" + duperSmoothieCount + "\t-- $" + duperSmoothieCount * duperSmoothiePrice);

        frozenBerries -= 6; // updating frozen berries
        greekYogurt -= 2; // updating greekYoogurt
        milk -= 12; // updating milks
        cups -= 1; // updating number of cups in stock
      }
      //if the order is SconeSmoothie
      if (sconeCount > 0 && anOrder.hasCombo() == false) {
        System.out.println("Scones : " + sconeCount + "\t\t-- $" + sconeCount * sconePrice);

        scones -= 1; // updating Number of Scones in stock
        totalSales += sconeCount;
        costOfOrder += sconeCount * sconePrice;

      }
      //Comb#1

      if (originalCount > 0 && anOrder.hasCombo() == true) {
        int numOfSConesEach = originalCount * 1;
        System.out.println("--Combo #1 Contains -- : \n" +
          " Original: " + originalCount + "\t\t -- $" + originalCount * orgPrice + "\n" + " Scone: " +
          numOfSConesEach + "\t\t -- $" + numOfSConesEach * sconePrice);
        System.out.println();

        frozenBerries -= originalCount * 4; // updating frozen berries
        milk -= originalCount * 8; // updating milks
        cups -= originalCount * 1; // updating number of cups in stock
        scones -= originalCount * 1; // updating scones

        totalSales += numOfSConesEach;
        costOfOrder += numOfSConesEach * sconePrice;

      }

      //Comb#2
      if (duperSmoothieCount > 0 && anOrder.hasCombo() == true) {
        int numOfSConesEach = duperSmoothieCount * 2;
        System.out.println("--Combo #2 Contains -- : \n" +
          " Duper Smoothie: " + duperSmoothieCount + "\t -- $" + duperSmoothieCount * duperSmoothiePrice + "\n" + " Scone: " +
          numOfSConesEach + "\t\t -- $" + numOfSConesEach * sconePrice);
        System.out.println();

        frozenBerries -= duperSmoothieCount * 6; // updating frozen berries
        milk -= duperSmoothieCount * 12; // updating milks
        cups -= duperSmoothieCount * 1; // updating number of cups in stock
        scones -= duperSmoothieCount * 2; // updating scones

        totalSales += numOfSConesEach;
        costOfOrder += numOfSConesEach * sconePrice;

      }

      System.out.println(".................");
      System.out.println("Total Sales " + totalSales);
    } else {
      System.out.println("You have no enough inventory to make new order");

    }

    return costOfOrder;
  }
  /**
   * a test method - do not change this code!
   * 
   */
  public static void main(String[] args) {
    Order comb1 = new Order();
    Order comb2 = new Order(2, 3);
    Order regularSmoothie = new Order(1, 1, 1, 4);

    SmoothieShop ss = new SmoothieShop();
    System.out.println("Total Cost : " + ss.processOrder(comb1));
    System.out.println();
    System.out.println("Total Cost : " + ss.processOrder(comb2));
    System.out.println();
    System.out.println("Total Cost : " + ss.processOrder(regularSmoothie));

  }
}