
public class MainClass2 {

	public static void main(String[] args) {
		
		 //1
        LineSegment AB = new LineSegment( new CSC142Point(1,6), new CSC142Point(5,1));
        //System.out.println(AB.slope());
        //2 
        LineSegment CD = new LineSegment(new CSC142Point(7,6), new CSC142Point(-7,-8));
       // System.out.println(CD.slope());
        
        /*A
         * What statement(s) would you write in order 
         * to successfully declare a new variable of 
         * type CSC142Point that stores the midpoint of line segment AB.
         */
        
        CSC142Point mAB = AB.midpoint();
        CSC142Point mCD = CD.midpoint();
        
        //System.out.println(mCD);
        
        /*B
         * What statement(s) would you write to successfully
         *  create a new LineSegment whose endpoints are the 
         *  first point of AB and the first point of CD.
         */

        LineSegment endpoint = new LineSegment(AB.getFirstPoint(),CD.getFirstPoint());
        
      
        /*C
         * What statement(s) would you write to create a new double 
         * (i.e. declare a new variable of type double) 
         * that stores the x coordinate of the first point of CD.
         */
        double xCoordinateCD= CD.getFirstPoint().getX();
        
        
        /*D
         * What statement(s) would you write to create a new double
         *  that stores the y coordinate of the midpoint of AB.
         */
        
        double yCoordinateMidPoint = mAB.getY();
        
        /*E
         * What statement(s) would you write to create a new LineSegment 
         * whose endpoints are the midpoint of AB and the midpoint of CD.
         */
        LineSegment endMipoint = new LineSegment( new CSC142Point(), new CSC142Point(mAB.getX(),mAB.getY()) );
        LineSegment endMipoint1 =  new LineSegment( new CSC142Point(), new CSC142Point(mCD.getX(),mCD.getY()) );
//        System.out.println(endMipoint.getFirstPoint());
//        System.out.println(endMipoint.getSecondPoint());
//        System.out.println(endMipoint1.getFirstPoint());
//        System.out.println(endMipoint1.getSecondPoint());
        
        /*F
         * Show the statement(s) that you used to find the distance 
         * from the midpoint of AB to the first point of CD
         * 
         */
        System.out.println(CD.getFirstPoint());
        //System.out.println(mAB);
        LineSegment md = new LineSegment(AB.midpoint(),CD.getFirstPoint());
        CSC142Point cs = new CSC142Point();
       
        
     
        /*G
         * Show the statement(s) that you used to find the distance 
         * from the first point of CD to the origin.
         */
        CSC142Point disto = new CSC142Point(CD.getFirstPoint().getX(),CD.getFirstPoint().getY());
        System.out.println(disto.distanceToOrigin());
        
        /*H
         * Show the statement(s) that use the toString() method of the 
         * CSC142Point class to display the second point of AB.
         */
        CSC142Point cs1 = new CSC142Point(AB.getSecondPoint().getX(),AB.getSecondPoint().getY());
       System.out.println(cs1.toString());
       
       /*I
        * Show the statement that uses the toString() method 
        * of the CSC142Point class to display BOTH points of AB.
        */
       
       /*
        * J
        * Show the statement that you used to change 
        * the first point of AB so that it is the same as the midpoint of CD.
        */
       CSC142Point samepoint = new CSC142Point(mCD.getX(),mCD.getY());
       
       AB.setFirstPoint(samepoint);
       System.out.println(AB.getFirstPoint());
       
       /*K
        * Show the statement(s) that you used to change the x coordinate of
        * the first point of AB so that it is the same as the x coordinate
        *  of the second point of CD.
        */
      CSC142Point samex = new CSC142Point(CD.getSecondPoint().getX(),AB.getFirstPoint().getY());
      
      AB.setFirstPoint(samex);
      System.out.println(AB.getFirstPoint());
        
	}

}
