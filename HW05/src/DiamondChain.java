import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
/*
 * EXTRA CREDIT :
 *  in my opinion why we make helper method private is because
 *  we design to reuse often by other methods or parts of a program.
 *  as long as this helper method is for other public methods 
 *  in the class it does'nt make any sense to make it's own context.
 *  so it's better to be private.
 */
public class DiamondChain {

   private File source;
   private String filename;
   private int counter;
   private double[][] array = {};
   /**
    * initializes a DiamondChain object
    * @param sources
    * @throws FileNotFoundException
    */
   public DiamondChain(File source) throws FileNotFoundException {
      this.filename = source.getPath();
      Scanner input = new Scanner(new File(filename));

      counter = 0;
      while (input.hasNext()) {
         String d = input.nextLine();

         counter++;

      }

      array = new double[counter][3]; // 2D array row-> number of counter and each row contains 3 col.
      Scanner input2 = new Scanner(new File(filename));
      for (int i = 1; i < counter; i++) {
    	if(input2.nextLine().length()<3) 
    	{
         for (int j = 0; j < 3; j++) {
            array[i][j] = input2.nextDouble();
         }
         }

      }

      input.close();

   }
  /**
   * @returns the number of Diamonds in this DiamondChain.
   * 
   */
   public int getCount()  {

      return counter-1;
   }
  /** takes a parameters and return the data of that row.
   * @param index 
   * @returns the Diamond at the specified index. 
   * @throws an IllegalArgumentException if the index is out of bounds.
   */
   public Diamond getDiamond(int index) {
    if(index>counter-1)
    {
    	throw new IllegalArgumentException("Index is out of bounds");
    }
      double h = array[index][0];
      double k = array[index][1];
      double l = array[index][2];

      Diamond d = new Diamond(h, k, l);
      return d;

   }

   /**
    * this method records changes in length between sequential Diamonds. 
    *  @return true if the length of diamond at index [i] is smaller than the length else false.
    */
   public boolean[] increasingLength() {

      boolean[] isIncrease = new boolean[counter];

      for (int i = 0; i < array.length - 1; i++) {
         if (array[i][2] < array[i + 1][2]) {
            isIncrease[i] = true;
         } else {
            isIncrease[i] = false;
         }
      }
      return isIncrease;
   }
  /**
   * this method returns all diamonds that are centered at the origin.
   * @return a  sorted array of Diamonds where all the Diamonds centered at the origin.
   */
   public Diamond[] originOrder() {
      Diamond[] d = new Diamond[counter];
      for (int i = 1; i < array.length ; i++) {
         double h = array[i][0];
         double k = array[i][1];
         double length = array[i][2];
         if (h == 0 && k == 0) {
            Diamond dm = new Diamond(h, k, length);
            d[i] = dm;
         }
          

      }
      return d;
   }
   /**
    * returns an array of the two Diamond objects whose centers
    *  are the farthest apart. The Diamonds may or 
    *  may not be sequential in the original file. 
    *  If there are 2 or more pairs of Diamonds 
    * that are the farthest, return the first pair found.
    * @return returns an array of the two Diamond objects whose centers are the farthest apart.
    */
   public Diamond[] getFarthest() {
      double h1 = array[0][0];
      double h2 = array[1][0];
      double k1 = array[0][1];
      double k2 = array[1][1];
      double length1 = array[0][2];
      double length2 = array[2][2];
      Diamond[] d = new Diamond[2];

      for (int i = 0; i < array.length-1 ; i++)

      {
         if (h1 < array[i][0]) {
            h2 = h1;
            h1 = array[i][0];

            if (k1 < array[i][1]) {

               k2 = k1;
               k1 = array[i][1];
               length2 = length1;
               length1 = array[i][2];

            } else {
               k2 = array[i][1];
               length2 = array[i][2];

            }

         } else {
            h2 = array[i][0];
            if (k1 < array[i][1]) {
               k2 = k1;
               k1 = array[i][1];
               length2 = length1;
               length1 = array[i][2];
            } else {
               k2 = array[i][1];
               length2 = array[i][2];
            }
         }

      } 
      
       
 
      Diamond dm = new Diamond(h1, k2, length2);
      Diamond dm1 = new Diamond(h2, k1, length1);
      d[0] = dm;
      d[1] = dm1;

      return d;

   }
   /**
    * @return  a String that represents the state of this object. 
    * The String should contain the toString() for each Diamond object, 
    * separated by a new line character.
    */
   public String toString() {
      String s = "";
      for (int i = 1; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            s += array[i][j] + " ";
         }
         s += "\n";
      }
      return s;
   }
   /**
    * write the results of a call to originOrder() to the file specified.
    *@param destination object
    *@throws IOException
    */
   public void saveOriginOrder(File destination) throws IOException {
      String currentPath = new File(".").getCanonicalPath();
 
      destination = new File(currentPath+"/saveOriginOrderFile.txt");
      // check if file exists in this directory 
      if (destination.createNewFile()) {
        System.out.println("File created: " + destination.getName());
      } 
      
      if (destination.exists())
      {
    	  FileWriter myWriter = new FileWriter(currentPath+"/saveOriginOrderFile.txt");
    	      
    	    	 for (int i = 1; i < array.length ; i++) {
    	    		 double h = array[i][0];
    	             double k = array[i][1];
    	             double length = array[i][2];
    	    		 if (h==0 && k==0)
    	    		 {
    	    			 myWriter.append(h + " "+ k + " " +length+"\n");
    	    		 }
    	    		 
    	    	 }
    	    
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	      
    	  
      }
     
   

   }
   public static void main( String[] args) throws IOException {

      Scanner in = new Scanner(System.in);
      String filename = in .next();
      File f = new File(filename);

      DiamondChain dc = new DiamondChain(f);
      
      Diamond d = dc.getDiamond(1);
      
      System.out.println(d.toString());
      System.out.println(dc.toString());
      System.out.println(Arrays.toString(dc.increasingLength()));
      System.out.println(Arrays.toString(dc.originOrder()));
      System.out.println(Arrays.toString(dc.getFarthest()));
      dc.saveOriginOrder(f);

   }
}