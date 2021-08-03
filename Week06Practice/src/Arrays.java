
public class Arrays {
	public static void main(String[] args) {
		 
		double [][] arr1= {{1, 2, 15, 16}, {6, 11, 7, 10}, {13, 12, 4, 5}, {14, 9, 8, 3}};
		int [][] arr2={{5, 5, 6}, {0, -1, 2}};
		//System.out.println(	isMagicSquare(arr1));
	//integer2Darray(arr1);
		//System.out.println(isSameShape(arr1,arr2));
		something(arr2);
	}
	
	public static void something(int[][] array) {
	    int sum = 0;
	    for (int r = 0; r < array.length; r++) {
	        for (int c= 0; c < array[r].length; c++) {
	               sum += array[r][c];
	        }
	        System.out.println(sum);
	    }   
	}
	
	/*
	 * Write a method that is passed in a full 2-D array of ints 
	 * and prints out its content; one row of values per line
	 */
	
	public static boolean isSameShape(double [][] arr1 , double [][] arr2)
	{
		boolean result=true;
		for(int i = 0;i<arr1.length;i++)
		{
			if (arr1.length==arr2.length)
			{
				if(arr1[i].length==arr2[i].length)
				{
					result=true;
				}
			}
			else
			{
				result= false;
			}
		}
		return result;
				
	}
	public static void integer2Darray(int[][] array)
	{
		for(int i=0; i<array.length;i++)
		{
			for (int j=0;j<array[i].length;j++)
			{
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static boolean isMagicSquare (int [][] arr)
	{
	   int sum = 0;
	    int sum1=0;
	    int sum3=0;
	    //row
	    for (int i=0;i<arr.length;i++)
	    {
	         sum += arr[0][i];
	         
	    }
	     for (int i=0;i<arr.length;i++)
	    {
	         sum1 += arr[i][0];
	    }
	     for (int i=0;i<arr.length;i++)
	    {
	         for (int j=0;j<=i;j++)
	         {
	             sum3 += arr[i][j];
	         }
	             

	    }
	    
	     System.out.println(sum);
	     System.out.println(sum1);
	    System.out.println(sum3);
	    if (sum1 == sum && sum3 ==sum )
	    {
	        return true;
	    }
	    return false;
	    
	}

public static int[][] matrixAdd(int [][] array1 , int [][] array2)
{
    
    int [][] sum = new int [array1.length][array1[0].length];
    for (int i =0 ; i<array1.length;i++)
    {
        for(int j=0; j<array2[i].length;j++)
        {
        sum [i][j]= array1[i][j]+array2[i][j];
        }
    }
    return sum;
}
	
	public static double[] sumEachPair(double [] array)
	{
		int count =0;
		if (array.length%2==0)
		{
			count=array.length/2;
			
		}
		if(array.length%2!=0)
		{
			count=(array.length/2)+1;
		}
		double [] newArray=  new double [count];
		
		for (int i=0;i<count;i++)
		{
			newArray[i]= array[i]+array[i+1];
		}
		
		for (int i=0;i<newArray.length;i++)
		{
			System.out.print(newArray[i]+ " ");
		}
		return newArray;
		
	}
	public static void shiftArray(int [] array, int shift)
	{
		int temp = array[0];
		for (int i =1; i<=shift-1;i++)
		{
			// 5 8 9 2 1
		     
		     array[i-1]= array[i];
		     
		}
		array[shift-1]= temp;
		for (int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+ " ");
		
		}
	}
	public static void reverse (int [] array)
	{
		 
		for (int i=0;i<array.length*0.5;i++)
		{
		 
				  
				int temp = array[i]; 
				array[i]= array[array.length-i-1];
				array[array.length-i-1]=temp;
				 
			
		}
		for (int i=0;i<array.length;i++)
		{
			System.out.print(array[i]);
		
		}
		
	}

}
