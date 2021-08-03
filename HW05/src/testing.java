import java.io.*;
 
import java.util.Arrays;
import java.util.Scanner;

public class testing {
public static void main(String[] args) throws IOException {
	//Scanner keyboard = new Scanner(System.in);
	String[] names = {"Mary", "Jose", "Minh"};
	System.out.println(names.toString());
    System.out.println("Enter the name of a text file:> ");
    String filename = "/Users/hodogas/Documents/Eclipse/HW05/src/shapes1.txt";
    Scanner input = new Scanner(new File(filename));
    
    //creating a file
   
    
    
    int count =0;
    while (input.hasNextLine())
    {
    	String d= input.nextLine();
    	count+=1;
    	
    }
    
  double [][] array = new double [count][3];
  Scanner input2 = new Scanner(new File(filename));
  
  for (int i=1;i<count;i++)
  { 
	 if (input2.nextLine().length()<3)
	 {
	  for (int j=0;j<3;j++)
	  {
		  
		 array[i][j]=input2.nextDouble();
			 
		  }
	  
	  }
  }
	  
  
  for (int i=1;i<count;i++)
  {
	  for (int j=0;j<3;j++)
	  {
		   
		 System.out.print(array[i][j]);
		  
	  }
	  System.out.println();
  }
  
  
   
    

}
}
