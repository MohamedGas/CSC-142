
/** Represents a 2-dimensional CSC142Point
 * @author CSC 142
 */
public class CSC142Point {
  private double x, y;  // the coordinates

// two different constructors
  
  /**
   * Create a CSC142Point at (0, 0)
   */
  public CSC142Point() {
    x = 0;
    y = 0;
  }
  
  /**
   * Create a CSC142Point with the given coordinates
   * @param initialX the x-coordinate
   * @param initialY the y-coordinate
   */
  public CSC142Point (double initialX, double initialY) {
    x = initialX;
    y = initialY;
  }

// update (mutator) methods 
// that change the state of a CSC142Point object 

  /**
   * Set the x-coordinate of this CSC142Point
   * @param x the new x-coordinate
   */
  public void setX(double x) {
    // Here's a situation where a local variable has the same name as
    // an instance variable. If we used
    // x = x;
    // Java would store the parameter value back into itself.
    // To access the instance variable, we must use the keyword this
    this.x = x;
  }
  
  /**
   * Set the y-coordinate of this CSC142Point
   * @param newY the new y-coordinate
   */
  public void setY(double updateY) {
    // No need to use the keyword this here, because the parameter
    // name differs from the instance variable name.
    y = updateY;
  }

  /**
   * Set the x and y coordinates of this CSC142Point
   * @param x the new x-coordinate
   * @param y the new y-coordinate
   */
  public void setPoint( double x, double y){
    this.x = x;
    this.y = y;
  }
  
// query (accessor) methods  
// that somehow report the state of a CSC142Point
// without changing it

  /**
   * Get the x-coordinate of this CSC142Point
   * @return the x-coordinate
   */
  public double getX() {
    return x;
  }
  
  /** 
   * Get the y-coordinate of this CSC142Point
   * @return the y-coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Calculate the distance between this CSC142Point and the origin
   * @return the distance to (0, 0)
   */
  public double distanceToOrigin() {
    return Math.sqrt(x * x + y * y);
  }
  
  
  /** Calculate the distance between this CSC142Point and some other CSC142Point
   * @param other the other CSC142Point
   * @return the distance between the 2 CSC142Points
   */
  public double distance(CSC142Point other) {
    double diffX = x - other.x;
    double diffY = y - other.y;
    return  Math.sqrt(diffX * diffX + diffY * diffY);
  }
  
  
  /**
   * Find the midpoint between this CSC142Point and another CSC142Point
   * @param p the other CSC142Point
   * @return the CSC142Point midway between the two CSC142Points
   */
  public CSC142Point midPoint(CSC142Point other) {
    double midX = (x + other.x) / 2;
    double midY = (y + other.y) / 2;
    return new CSC142Point(midX, midY);
  }
  
  /**
   * The String version of this CSC142Point
   * @return the String representation
   */
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
  
  /**
   * a test method - do not change this code!
   * it should display 3 results in a terminal window
   */
  public static void test (){
      CSC142Point alpha = new CSC142Point( 5, 5 );
      CSC142Point beta = new CSC142Point( -3, 7 );
      System.out.println( "alpha is " + alpha.distanceToOrigin() + " from the origin" );
      System.out.println( "The x coordinate of beta is " + beta.getX() );
      beta.setY( 72 );
      System.out.println( "The y coordinate of beta is " + beta.getY() );
      
      
    }
  /** Calculate the distance between this CSC142Point and some other CSC142Point
   * @param other the other CSC142Point
   * @return the distance between the 2 CSC142Points
   */
  public boolean length(CSC142Point other) {
    if (x==other.x)
    {
    	return true;
    }
    else
    {
    	return false;
    }
  }
  

  
}