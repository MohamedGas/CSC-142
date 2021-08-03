
public class Main {

	public static void main (String[] args)
	{
		Crayon cr = new Crayon();
		Marge mg = new Marge();
		mg.getNumber(cr);
		
		Crayon cr1 = mg.favorite();
		 
		System.out.print(cr1.getA());
	}
}
