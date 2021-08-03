
public class WordCount {

	public static void main(String[] args) {

        
		
		
		int vowelCounts = 0;
		int consantCounts = 0;
		int wordCount=1;
		String vowels ="aeiou";
		String consants ="bcdfghjklmnpqrstvwxyz";
		String	space=" ";
		String string [] = {"h","o","w"," ","M","a","n","y"," ","w","O","r","d","s","\0"};
		 
		for (String letters : string)
		{
			 
			if (vowels.contains(letters) || vowels.toUpperCase().contains(letters))
			{
				vowelCounts+=1;
			}
			if (consants.contains(letters) || consants.toUpperCase().contains(letters))
			{
				consantCounts+=1;
			}
			if (letters.equals(" "))
			{
				wordCount+=1;
			}
		}
		
		System.out.println("vowels: "+ vowelCounts);
		System.out.println("consants: "+consantCounts);
		System.out.println("Words: "+wordCount);
		

	}

}
