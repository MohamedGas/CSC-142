import java.util.Arrays;

public class Diamond {

    private double k;
    private double h;
    private double length;
    /**
     * initialize this Diamond object with the given data.
     * @param h , k ,length
     * @throws Throws an IllegalArgumentException for length<= 0
     */
    public Diamond(double h, double k, double length) {
       if (length <= 0) {
          throw new IllegalArgumentException("Length should be >=1");
       }
       this.h = h;
       this.k = k;
       this.length = length;

    }
    /**
     * getting Center X
     * @return the x coordinate for the center of this Diamond
     */
    public double getCenterX() {
       return h;

    }

    /**
     * getting Center Y 
     * @returns the y coordinate for the center of this Diamond
     */
    public double getCenterY() {
       return k;

    }
    /**
     * Getiing Length from the center
     *@return the length from the center of this Diamond to a corner
     */
    public double getLength() {
       return length;
    }

    /**
     * String representation of this Diamond's equation
     * @return a String representation of this 
     * Diamond's equation:  |x - h| + |y - k| = l. 
     *  NOTE - if h or k are negative, 
     *  either put that number in parentheses 
     *  or convert the subtraction to addition. 
     *  If either h or k are 0, do not include 
     *  the coordinate in the equation
     */
    public String toString()

    {
       double temph = h;
       double tempk = k;
       String signh = "";
       String signk = "+";
       if (h > 0) {
          signh = "-";
       } else if (h < 0) {
          signh = "+";
          temph = Math.abs(h);
       }
       if (k > 0)

       {
          signk = "-";

       } else if (k < 0) {
          signk = "+";
          tempk = Math.abs(k);
       }
       if (h == 0 && k == 0) {
          return "|" + " x " + "| + | y " + "|" + " = " + length;

       }

       return "|" + " x " + signh + " " + temph + "| + | y " + signk + " " + tempk + "|" + " = " + length;
    }
    /**
     * these are points on the regular coordinate plane
     * that you're used to from math class
     * @return an array containing the 4 corners of this Diamond
     *  as CSC142Point objects.  
     *  The order of the points is as 
     *  follows [top, right, bottom, left]  
     *  Remember - 
     *  these are points on the regular coordinate plane 
     *  that you're used to from math class. 
     *  Y coordinates become smaller as we move down.
     */
    public CSC142Point[] getCorners() {
       // Top to Bottom x don't change 
       //top
       double topX = h;
       double topY = k + length;
       //bottom
       double bottomX = h;
       double bottomY = k - length;

       //Left to Right y don't change
       //left 
       double leftX = h + length;
       double leftY = k;
       //Right
       double rightX = h - length;
       double rightY = k;

       CSC142Point top = new CSC142Point(topX, topY);
       CSC142Point bottom = new CSC142Point(bottomX, bottomY);
       CSC142Point left = new CSC142Point(leftX, leftY);
       CSC142Point right = new CSC142Point(rightX, rightY);

       CSC142Point[] csc142Points = {
          top,
          bottom,
          left,
          right
       };
       return csc142Points;
    }
    /**
     * @return the area of this Diamond
     */
    public double area() {
       double diagonalX = (h + length) - (h - length);
       double diagonalY = (k + length) - (k - length);
       return (diagonalX * diagonalY) * 0.5;

    }
    /**
     * the perimeter of this Diamond
     * @return the perimeter of this Diamond
     */
    public double perimeter() {
       double diagonalX = ((h + length) - (h - length)) / 2;
       double diagonalY = ((k + length) - (k - length)) / 2;
       double perimeter = Math.sqrt(Math.pow(diagonalX, 2) + Math.pow(diagonalY, 2));
       return perimeter;
    }
    /**
     * these are points on the regular coordinate plane 
     * that you're used to from math class
     * @param x , y
     * @return true if these coordinates are located on the 
     * perimeter or interior of this Diamond, false if not
     */
    public boolean contains(double x, double y) {
       return true;
    }
    /** 
     * the distance from this Diamond's center 
     * to the other Diamond's center.
     * @param other
     * @return the distance from this Diamond's
     *  center to the other Diamond's center.
     */
    public double distance(Diamond other) {
       double diffCenter = Math.abs(length - other.length);
       return diffCenter;
    }
    /** changes the center of this Diamond
     * @param h,k
     */
    public void setCenter(double h, double k) {
       this.h = h;
       this.k = k;

    }
    /**
     * changes the length from the center to a corner of this Diamond.
     * @throws Throws an IllegalArgumentException if length<= 0.
     * @param length 
     */
    public void setLength(double length) {
       if (length <= 0) {
          throw new IllegalArgumentException("Length should >=1");
       }
       this.length = length;
    }
    public static void main(String[] args) {
       Diamond d = new Diamond(3, -2, 4);
       //System.out.println( Arrays.asList(d.getCorners()));

    }

 }