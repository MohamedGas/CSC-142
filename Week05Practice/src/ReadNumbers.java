import java.io.*;
import java.util.*;
/**
 * Program to read in numbers from a text file and display them to the user
 * 
 * @author csc 142
 */
public class ReadNumbers
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file of numbers:> ");
        String filename = "/Users/hodogas/Documents/Eclipse/Week05Practice/src/textFile1.txt";
        
        Scanner input = new Scanner(new File(filename));
        
        int i = 0;
        
        // while there is another number to read
        while (input.hasNextInt()){
            double d = input.nextInt();  // read it
            
            i++;
            System.out.println("[value " + i + "] = " + d);
        }
        input.close();    // Make sure to close the file when done. Free up resources
    }
}