
public class MainClass4 {

	public static void main(String[] args) {
		Sample s = new Sample( );
		Sample t = new Sample( );
		s.modify( );
		// alpha 3 beta -2
		t.increase(3);
		// 2 , 6
		//s.display( );
		//t.display( );
		int x = s.scramble( 2 ); //-1 
		s.increase( x );
		// 2 ,-3
		//s.display( );
		t.increase ( s.scramble( -2 ) ); // 1-> 3 7
		t.display( );
		
	}
}
