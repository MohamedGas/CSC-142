public class Fraction {

   private int denominator;
   private int numerator;
   private double fraction;

   public Fraction() {
      denominator = 1;
      numerator = 1;
      fraction = numerator / denominator;

   }

   public Fraction(int n, int d)

   {
      this.numerator = n;
      this.denominator = d;

      if (d == 0) {
         throw new IllegalArgumentException();
      } else {
         this.fraction = n / d;
      }

   }

   /*
    * Accessor
    */
   public int getDenominator() {
      return denominator;
   }
   public int getNumerator() {
      return numerator;
   }

   public double getFraction() {
      return fraction;
   }

   public Fraction multiply(Fraction f)

   {

      int r1 = numerator * f.numerator;

      int r2 = denominator * f.denominator;

      return new Fraction(r1, r2);

   }
   public String toString() {
      return "(" + numerator + ", " + denominator + ")";
   }
   //Mutator

   public void setDenominator(int denominator) {
      this.denominator = denominator;
   }

   public void setNumerator(int numerator) {
      this.numerator = numerator;
   }

   public void setFraction(double fraction) {
      this.fraction = fraction;
   }
////GCD
//   If N equals 0, stop
//   store N in T
//   store M %N back in N
//   store T in M
//   go back to step 1
   
   
   public void reduce(int M ,int N)
   {
	   if ( N ==0)
	   {
		   throw new IllegalArgumentException();
	   }
	   int T;
	   T= N;
	   N= M%N;
	   M=T;
	   T=N;
	   System.out.println(T);
   }
   public static void main(String[] args) {
      Fraction f = new Fraction(2, 5);
      Fraction fr = new Fraction(3, 5);

      f.reduce(120, 50);
   }
}