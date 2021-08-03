
/**
 * Represent a line-segment in a 2-dimensional coordinate plane by keeping track 
 * of its endpoints.
 * In order for clarity on which point a client specifies, we refer to a first point
 * and a 2nd point.  The first point is the 1st parameter to the constructor.
 * 
 * @author csc142
 */
public class LineSegment
{
     private CSC142Point p1, p2;

    /**
     * Create a LineSegment defined by these 2 endpoints
     * @param p1 the first point
     * @param p2 the second point
     */
    public LineSegment(CSC142Point p1, CSC142Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }
    /**
     * replace the current first point with the parameter
     * @param p the new first point
     */
    public void setFirstPoint(CSC142Point p)
    {
        this.p1 = p;
    }
     /**
     * replace the current second point with the parameter
     * @param p the new second point
     */
    public void setSecondPoint(CSC142Point p)
    {
        this.p2 = p;
    }
    
    /**
     * Retrieve the first point of this LineSegment
     * @return the first point 
     */
    public CSC142Point getFirstPoint()
    {
        return p1;
    }
     /**
     * Retrieve the second point of this LineSegment
     * @return the second point 
     */
    public CSC142Point getSecondPoint()
    {
        return p2;
    }
    
    /**
     * Calculate the slope of this LineSegment.  Will throw an ArithmeticException
     * if the slope is undefined (a vertical LineSegment)
     * @return the slope
     */
    public double slope()
    {
        double x, y;
        x = this.p1.getX() - this.p2.getX();
        y = this.p1.getY() - this.p2.getY();
        return y/x;
    }
    
    /**
     * Calculates the distance between the given Point and the midpoint of this
     * LineSegment
     * @param p the point to calculate the distance to
     * @return the distance
     */
    public double distance(CSC142Point p) 
    {
        CSC142Point middle = this.midpoint();  
        return p.distance(middle);
    }
    
    /**
     * Finds the midpoint of this LineSegment
     * @return the midpoint Point
     */
    public CSC142Point midpoint()
    {
        CSC142Point temp = p1.midPoint(p2);
        return temp;
    }
    
    /**
     * Creates a new LineSegment that has as its endpoints the midpoint of this
     * LineSegment and the other LineSegment
     * @param other the 2nd LineSegment
     * @return a new LineSegment
     */
    public LineSegment connectMids(LineSegment other)
    {
        CSC142Point mid1 = this.midpoint();
        CSC142Point mid2 = other.midpoint();
        LineSegment result = new LineSegment(mid1, mid2);
        return result;
    }
    
    /**
     * Calculate the slope of this LineSegment.  Will throw an ArithmeticException
     * if the slope is undefined (a vertical LineSegment)
     * @return the slope
     */
    public String isVertical()
    {
        double x, y;
        double slope=0;
        String status="";
        x = this.p1.getX() - this.p2.getX();
        y = this.p1.getY() - this.p2.getY();
        if (this.p1.getX() ==this.p2.getX())
        {
        	
        	
        	status= "verticle";
        	
        	
        }
        else
        {
        	System.out.println(slope());
        }
        
        
        return status;
 
    }
    
     
    
}