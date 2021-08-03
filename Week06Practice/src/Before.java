import java.util.Iterator;





 

class  Before {
	
	public static String reversedString (String s)
	{    
		String newString =" ";
		
		char last =' ';
		
		if ( s.length()%2!=0)
			
		{
			last = s.charAt(s.length()-1);
			for (int i =0 ;i <s.length()-1;i+=2)
			{
				newString += s.charAt(i+1);
				newString+=s.charAt(i);
				
				
			}
			newString+=last;
				
			
			
		}
		else
		{
			for (int i =0 ;i <s.length()-1;i+=2)
			{
				newString += s.charAt(i+1);
				newString+=s.charAt(i);
				
				
			}
		}
		return newString;
		
		
		
		
	}
	
	
	
	
	
	public static void countZerosInInteger(int num)
	{
		String nums = String.valueOf(num);
		int count = 0;
		for ( int i =0; i<nums.length();i++)
		{
			if (nums.charAt(i)=='0')
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void factors (int num)
	{
		int i=1;
		while (num/i!=1)
		{
			if (num%i==0)
			{
				System.out.println(i);
			}
			i++;
		}
		System.out.println(num);
		
	}

	public static void stringDashed(String s)
	{
		System.out.print(s.charAt(0));
		for (int i=1;i<s.length();i++) 
		{
			System.out.print("-"+s.charAt(i));
		}
	}
	
	// check double 
	
	public static boolean doubleChar(String s)
	{
		return true;

	}
public static double sampleTest2Lawsuit( double award ) 
{ 
    double t1 = 100000; 
    double t2 = 500000; 
    double rateBelowT1 = 0.5; 
    double rateT1ToT2 = 0.3; 
    double rateAboveT2 = 0.1; 
    double fee; 
    if ( award <= t1 ) 
        fee = award * rateBelowT1; 
    
    else if ( award <= t2 ) 
        fee = t1 * rateBelowT1 + (award - t1) * rateT1ToT2; 
    // 50,000+(50,000)*0.3
    
    else 
        fee = t1 * rateBelowT1 + (t2 - t1) * rateT1ToT2 + (award - t2) * rateAboveT2; 
    if ( fee < 20000 ) 
        fee = 20000; 
    return (award - fee); // return amount you get to keep!! 
}
	 
	 public static void fibonaci(int  n)
	 {
		 // 1 1 2 3 5 8 13
		 
		 
		int p1=0;
		int p2=1;
		int total=0;
		System.out.print(p1);
		for (int i = 0; i <100; i++) {
			System.out.print(  ", "+p2);
			int sum = p1+p2;
			//total+=sum-p1;
			p1=p2;
			p2= sum;
			
			
		}
		System.out.println();
		///System.out.println(total);
		
		
		 
		
		 
		 
		  
		 
	 }
public static void main(String[] args) {
	
//System.out.println(sampleTest2Lawsuit(150000));
	//stringDashed("Mohamed");
	//System.out.println();
	//System.out.println(doubleChar("mohaamed"));
	//factors(12);
	//countZerosInInteger(12000045);
	System.out.println(reversedString("person"));
}
}
