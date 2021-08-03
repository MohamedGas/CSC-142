import java.util.Random;

//import java.util.Random;
public class mid {
public static void main(String[] args) {
	
	
int x =5;


   for (int i =0; i<5; i++)
   {
	   int f= i*2+2;
	   
	   for (int j= i; j<=i;j++)
	   {
		   
		   System.out.print(f);
	   }
	   for (int k = 1;k<=i;k++)
	   {
		   System.out.print("-"+ (f-k));
	   }
	   System.out.println();
   }
    
//	what(2,2);
//	what(6,4);
	
	
//	
//	System.out.println(isInQuadrantOne('k'));
//	double z=0 ;
//	double x =1;
//	double r1=0;
//	double G = (2-z)/(Math.pow (x ,3*r1));
//	System.out.println(G);
//	
//	int r = 16;
//	int s= 0;
//	while (r>2)
//	{
//		for (s=2;s<=r;s+=3)
//		{
//			System.out.print(s+" ");
//		}
//		System.out.println();
//		r/=2;
//	}
//	System.out.println("r = "+ r+ " s = "+s);
}
public static void what ( int w , int g)
{
	if ( w<g-1)
	{
		g+=3;
		
	}
	else if (w==g)
	{
		g=-1;
	}
	if ( g==-1 || w>g)
	{
		w+=3;
		g+=3;
	}
	System.out.println(g+" "+w);
}

public static boolean isInQuadrantOne ( char ch)

{
	//return (x<0 && y>0) || (x<0 && y<0)|| (x>0 && y<0);
	
	return ch <= 'a' && ch <= 'z';
 
}

    public static void method(int n) {
    	for (int i = 2; i <= n; i+=2) {
    	      for (int j = 1; j <= i; ++j) {
    	        System.out.print(i);
    	      }
    	      System.out.println();
    	    }
        
}





//public class TicketMachine
//{
//	private int tickets;
//
//	private int countsales =0;
//	
//
//	public TicketMachine(int count)
//	{
//		this.tickets= count;
//		this.countsales++;
//	}
//	public void sellTicket (int numbers)
//	{
//		if ( numbers>0)
//		{
//			tickets-=numbers;
//		}
//		
//	}
//	int numberSold()
//	{
//		return tickets;
//		
//	}
//	
//	double average()
//	
//	{
//		if (tickets==0)
//		{
//			return 0;
//		}
//		return tickets/countsales;
//	}
//	double maxTransaction()
//	{
//		if (tickets==0)
//		{
//			return 0;
//		}
//		return Math.max(countsales, countsales)
//		
//	}
//
//}
//	
}
