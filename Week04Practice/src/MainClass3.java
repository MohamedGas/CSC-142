
public class MainClass3 {

	public static void main(String[] args) {
		
		CSC142Point p = new CSC142Point();
		CSC142Point q = new CSC142Point( 3, 4 ); // draw an object diagram for p and q at this point

		p.setX(1);
		//System.out.println(p.getX());
     	p.setY( q.getX() + 1 );
     //	System.out.println(p.getY());
	q.setX( 1 + p.getX() ); // draw another object diagram for p and q showing the new states
	//System.out.println(q.getX());
//
	CSC142Point t;
		t = p;
		System.out.println(t.getX());
		
	p = q;
	System.out.println(p.getX());
	q = t;
	System.out.println(q.getX());
	t = null; // what does the object diagram for p and q look like now?
	//System.out.println(t.getX());
//
		double y1 = q.getY() + 2;
    	q.setY( y1 );
    	System.out.println(q.getY());
    	p.setX( q.getX() + p.getY() ); // draw an object diagram showing the final states of p and q;
        System.out.println(p.getX());
       

	}

}
