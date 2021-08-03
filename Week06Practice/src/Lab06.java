
public class Lab06 {

	
	public static void main(String[] args) {
		int a1 []= {8,3,5,7,2,4};
		int a2 []= {15,22,8,19,31};
		System.out.println(range(a2));
	}
	public static int range(int [] num)
	{
		int maxValue = num[0];
		int minValue = num[0];
		int result =0;
		for (int i = 1; i<num.length;i++)
		{
			if (num[i]>maxValue)
			{
				maxValue=num[i];
			}
			if (num[i]<minValue)
			{
				minValue=num[i];
			}
			
		}
		result = (maxValue-minValue)+1;
		
		return result;
	}
}
