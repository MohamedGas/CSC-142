import java.util.Arrays;

public class Sortings {

	public static void main(String[] args) {
		
		int [] array= {7,2,12,8,3};
		//bubbleSort(array);
        insertionSort(array);
	}
	
	public static void insertionSort(int [] array)
	{
		for (int i =1; i<array.length;i++)
		{
			int  j=i;
			while (j>0 && array[j-1]>array[j])
			{
				int temp= array[j];
				array[j]=array[j-1];
				array[j-1]=temp;
				j=j-1;
			}
			
		}
		for (int s = 0; s < array.length; s++) {
			System.out.print(array[s] + " ");
		}
	}
	
	public static void bubbleSort(int[] array)
	{

		for(int i =0; i<array.length;i++)
		{
			for (int j = i+1; j<array.length;j++)
			{
				if (array[i]>array[j])
				{
					int temp = array[i];
					array[i]= array[j];
					array[j]=temp;
				}
			}
		}
		
		
		
		for (int s = 0; s < array.length; s++) {
			System.out.print(array[s] + " ");
		}
		
		 
	}

}
