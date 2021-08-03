import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Program to read in a text file and print out the number of characters for each "word"
 * 
 * @author csc142
 */
public class ReadStrings
{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of a text file:> ");
        String filename = keyboard.next();
       
        readInput(filename);
        System.out.println("good-bye");
    }
    
	/**
	* method to read in text froma file and display each String and its length.
	* @param name the name of the file to open for reading
	* @throws FileNotFoundException if the file cannot be found
	*/
	
    public static void readInput(String name) throws FileNotFoundException {
        Scanner input = new Scanner(new File(name));
        
        // as long as there is another String to read
        while (input.hasNext()){
            String s = input.next();  // read it
            if (s.length() == 1)
                System.out.println("\"" + s + "\" has " + s.length() + " character.");
            else
                System.out.println("\"" + s + "\" has " + s.length() + " characters.");
        }
        input.close();   // Make sure to close the file when done. Free up resources
    }
}