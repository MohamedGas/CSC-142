
/**
 * Representation of a complex number of the form <b>a + bi</b>
 * 
 * @author CSC 142 
 */
public class Complex
{
    // adopting the traditional variable names for a + bi
    private double a, b;  // where a is the real part, b the imaginary part

    /**
     * Construct a Complex number with value 0 + 0i
     */
    public Complex() {
        // initialize the instance variables
        a = 0;
        b = 0;
    }

    /**
     * Construct a Complex number with the specified values for a and b.
     * @param initialA = the real part of the Complex number
     * @param initialB = the coefficient for the imaginary part of the Complex number
     */
    public Complex(double initialA, double initialB) {
        //initialize the instance variables
        a = initialA;
        b = initialB;
    }
	
    /**
     * Get the real part of this Complex number
     * @return the real part (a of a+bi)
     */
    public double getReal(){
        return a;
    }
    
    	
    /**
     * Get the coefficient of the imaginary part of this Complex number
     * @return the coefficient b (b of a+bi)
     */
    public double getImaginary(){
        return b;
    }
    
    /** 
     * Set the real part of this Complex number
     * @param newA  the new a component for a + bi
     */
    public void setReal(double newA) {
        a = newA;
    }
    
    /** 
     * Set the coefficient of the imaginary part of this Complex number
     * @param newB  the new B component for a + bi
     */
    public void setImaginary(double newB) {
        b = newB;
    }
    
    /**
     * Sum up this Complex number and the other Complex number. Return the result
     * @param other  the second operand for this addition
     * @return a new Complex number that represents the sum
     */
    public Complex add(Complex other){
        double newA = a + other.a;
        double newB = b + other.b;
        return new Complex(newA, newB);
    }
    
    /**
     * Multiply this Complex number and the other Complex number. Return the result
     * @param other  the second operand for this multiplication
     * @return a new Complex number that represents this product
     */
    public Complex multiply(Complex other){
        double newA = a * other.a - (b * other.b);
        double newB = a * other.b + b * other.a;
        return new Complex(newA, newB);
    }   
    
    /**
     * String representation of this Complex number
     * @return a String of the form a + bi
     */
    public String toString() {
        return a + " + " + b + "i";
    }
    
    /**
     * Returns the conjugate of this Complex number.
     * @return the conjugate (the imaginary part has the opposite sign from the original)
     */
    public Complex conjugate(){
        return new Complex(a, -b);
    }
    
    /**
     * Calculates the absolute value of this Complex number
     * @return the absolute value defined as sqrt(a^2 + b^2)
     */
    public double abs() { 
        return Math.sqrt(a * a + b * b);
    }
    
    /**
     * a test method - do not change this code!
     * it should display 6 lines in a terminal window
     */
    public static void main (String[] args){
        Complex c = new Complex();
       Complex c2  = new Complex(4, -5);
c.setImaginary(2);
Complex r = c.add(c2);
System.out.println(r.toString());
    }

}