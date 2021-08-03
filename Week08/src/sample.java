import jdk.jshell.Diag;
 

public class sample {

	public static void main(String[] args) {
		
		Display(5);
	}
	
	public  static void Display (int x )

	{
	   for (int i =0; i<x; i++)

	   {

	       int f= i*2+2;

	     for (int j= i; j<=i; j++)

	  {

	     System.out.print(f);

	  }
	      

	     for (int k = 1;k<=i;k++)

	  {

	      System.out.print("-"+ (f-k));

	  }
	     System.out.println();

	}

	     

	   }
}
