
public class MidPracriceIt {
public static void main(String[] args) {
	
 sequenceSum(2.7);
	
}

public static double  sequenceSum( double num)
{
    double total = 0.0;
    System.out.print("1");
    if ( num == 1.0)
    {
    	 System.out.print("1 = 1.000");
    }
    
       double i = 0;
    while (num>=total)
    {
    	 i++;
        total += (1)/i;
        System.out.print(" + " + 1 + "/" + i);
      
        
    }
    System.out.println(total);
    return total;
    
}
}
