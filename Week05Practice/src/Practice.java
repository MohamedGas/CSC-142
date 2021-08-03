import java.io.*;
import java.util.*;
public class Practice {
	public static void main(String[] args) throws FileNotFoundException  {
		int x;
		for ( x = 2; x < 10; x = x * x )

		System.out.print( x + " " );
		System.out.println( "Final x = " + x );	
		
	}
	
	
	public static void readNumber ( String fileName) throws FileNotFoundException
	{
		
		Scanner input = new Scanner(new File(fileName));
     int i =0;
		
		while (input.hasNextBoolean())
		{
			Boolean d = input.nextBoolean();
			i++;
			System.out.println("[Value "+i+" ]= "+d);
			
		}
		input.close();
		
	}
	/*
	 * 
	 */
	
	public static void readString(String fileName)  throws FileNotFoundException{
		fileName= "/Users/hodogas/Documents/Eclipse/Week05Practice/src/textFile1.txt";
		Scanner input = new Scanner(new File(fileName));
		 
		while(input.hasNext())
		{
			String st = input.nextLine();
			
			 
		    
			System.out.println(st  + " ");
			 
		}
		input.close();
		
	}

}
