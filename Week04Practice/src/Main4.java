import javax.sound.sampled.Line;

 
public class Main4 {

	public static void main(String[] args) {
		LineSegment AB = new LineSegment( new CSC142Point( 1,6 ), new CSC142Point( 5, 1) );
		
	    LineSegment CD = new LineSegment(new CSC142Point(7,6), new CSC142Point(-7,-8));
	      
	    //A
	    CSC142Point mdAB=  AB.midpoint();
	    CSC142Point mdCD = CD.midpoint();
	    
	    //B
	    
	    LineSegment endPoint = new LineSegment(AB.getFirstPoint(),CD.getFirstPoint());
	    System.out.println(mdAB);
	  
	    
	    //C
	    double xCoordOfCD= CD.getFirstPoint().getX();
	    
	    //D
	    double yCoordOfMdAB= mdAB.getY();
	    System.out.println(yCoordOfMdAB);
	    
	    //E
	    
	    LineSegment endMid = new LineSegment(mdAB,mdCD);
	    
	    //F
	    CSC142Point p= new CSC142Point();
	    LineSegment distToMid = new LineSegment( mdAB, CD.getFirstPoint());
	    System.out.println(distToMid.distance(p));
	    //G
	    CSC142Point p1= new CSC142Point(CD.getFirstPoint().getX(),CD.getFirstPoint().getY());

	    System.out.println(p1.distanceToOrigin());
	    
	    //H
	    
	    CSC142Point secondPoint = new CSC142Point(AB.getSecondPoint().getX(),AB.getSecondPoint().getY());
	    System.out.println(secondPoint.toString());
	    
	    //I
	    
	    CSC142Point toStringAB = new  CSC142Point(AB.getSecondPoint().getX(),AB.getSecondPoint().getY());
	    CSC142Point toStringCD = new  CSC142Point(CD.getSecondPoint().getX(),CD.getSecondPoint().getY());
        System.out.println(toStringAB + " , " +toStringCD);
        //J
        
        AB.setFirstPoint(mdCD);
        System.out.println(AB.getFirstPoint());
        //K
        AB.getFirstPoint().setX(CD.getFirstPoint().getX());
        System.out.println(AB.getFirstPoint());
        
        //

        
        
	}
}
