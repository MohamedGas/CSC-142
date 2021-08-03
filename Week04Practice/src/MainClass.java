
/**
 * Write a description of class MainClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainClass {
	

	public static void main (String[] args)
    {
        //1
        LineSegment AB = new LineSegment( new CSC142Point(1,6), new CSC142Point(5,1));
        //System.out.println(AB.slope());
        //2 
        LineSegment CD = new LineSegment(new CSC142Point(7,6), new CSC142Point(-7,-8));
       // System.out.println(CD.slope());
        
        /*
         * What statement(s) would you write in order 
         * to successfully declare a new variable of 
         * type CSC142Point that stores the midpoint of line segment AB.
         */
        CSC142Point mAB= AB.midpoint();
        CSC142Point mCD= CD.midpoint();
        
        System.out.println(mAB +" mid point AB");
        System.out.println(mCD + " mid point CD");
        
        /*
         * What statement(s) would you write to successfully
         *  create a new LineSegment whose endpoints are the 
         *  first point of AB and the first point of CD.
         */
         
       LineSegment end = new LineSegment(AB.getFirstPoint(),CD.getFirstPoint());
       // System.out.println(end.getSecondPoint()+" B");
        /*
         * What statement(s) would you write to create a new double 
         * (i.e. declare a new variable of type double) 
         * that stores the x coordinate of the first point of CD.
         */
        CSC142Point setCD = new CSC142Point();
        setCD.setPoint(7, 6);
        //System.out.println( setCD.getX() +" "+  setCD.getY()+ " C");
        
        /*D
         * What statement(s) would you write to create a new double
         *  that stores the y coordinate of the midpoint of AB.
         */
        CSC142Point setAB = new CSC142Point();
        setAB.setY(mAB.getY());
        //System.out.println(setAB.getY());
        
        /*E
         * What statement(s) would you write to create a new LineSegment 
         * whose endpoints are the midpoint of AB and the midpoint of CD.
         */
        
        LineSegment md = new LineSegment(new CSC142Point(mAB.getX(),mAB.getY()),new CSC142Point(mCD.getX(),mCD.getY()));
        //System.out.println(md.getFirstPoint());
       // System.out.println(md.getSecondPoint());
        
        /*F
         * Show the statement(s) that you used to find the distance 
         * from the midpoint of AB to the first point of CD
         * 
         */
        
        LineSegment dis = new LineSegment( mAB,CD.getFirstPoint());
        
         CSC142Point cs = new CSC142Point();
        // System.out.println(CD.getFirstPoint());
        //System.out.println( dis.distance(cs));
        
        /*G
         * Show the statement(s) that you used to find the distance 
         * from the first point of CD to the origin.
         */
        
        CSC142Point disTo = new CSC142Point(CD.getFirstPoint().getX(),CD.getFirstPoint().getY());
        disTo.distanceToOrigin();
       // System.out.println( CD.getFirstPoint());
       // System.out.println( disTo.distanceToOrigin());
        
        /*H
         * Show the statement(s) that use the toString() method of the 
         * CSC142Point class to display the second point of AB.
         */
        CSC142Point secondpart = new CSC142Point(AB.getSecondPoint().getX(),AB.getSecondPoint().getY());
        secondpart.toString();
        //System.out.println(secondpart.toString());
        
        /*I
         * Show the statement that uses the toString() method 
         * of the CSC142Point class to display BOTH points of AB.
         */
        
        
        
        CSC142Point pA = new CSC142Point(AB.getFirstPoint().getX(),AB.getFirstPoint().getY());
        CSC142Point pB = new CSC142Point(AB.getSecondPoint().getX(),AB.getSecondPoint().getY());
        //System.out.println(pA.toString());
        //System.out.println(pB.toString());
        
        /*
         * J
         * Show the statement that you used to change 
         * the first point of AB so that it is the same as the midpoint of CD.
         */
        //AB.setFirstPoint(CD.midpoint());
       // System.out.println(AB.getFirstPoint());
        
        /*K
         * Show the statement(s) that you used to change the x coordinate of
         * the first point of AB so that it is the same as the x coordinate
         *  of the second point of CD.
         */
       CSC142Point samex = new CSC142Point(CD.getSecondPoint().getX(),AB.getFirstPoint().getY());
       
       AB.setFirstPoint(samex);
       System.out.println(AB.getFirstPoint());
       
       /*
        * L
        * Write a method for the LineSegment class that returns 
        * the length of this LineSegment.
        */
       
       /*
        * Write a method that returns whether this 
        * LineSegment is vertical or not (undefined slope)
        */
      System.out.println(AB.getFirstPoint() + " "+ AB.getSecondPoint());
      System.out.println(AB.isVertical());
      
       
    }
	

}
