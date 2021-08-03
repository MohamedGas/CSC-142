import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * Provides a GUI interface to allow a user to read in a file of Diamonds,
 * and get interesting stats
 * 
 * You are not responsible for understanding this code, but if you have any questions,
 * I'd be happy to answer them.
 * 
 * NOTE - if you want to call more methods, add statements to the method
 * buildDisplay()
 * 
 * @author csc142 
 */
public class DiamondApp
{
    private JTextArea text; 
    
    /**
     * Constructor for objects of class DiamondApp
     */
    public DiamondApp()
    {
        JFrame win = new JFrame("142 Diamonds");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800, 850);
        
        // Create the button 
        JButton button = new JButton("Load File");
        
        // put button in a panel and then into the frame
        JPanel back = new JPanel();
        back.setBackground(Color.blue);
        back.add(button);
        win.getContentPane().add(back,BorderLayout.SOUTH );
        
        // now set up the event handler
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                process();
            }
            
        });
        
        // create the display area and place it
        text = new JTextArea();
        JScrollPane p = new JScrollPane(text);
        win.getContentPane().add(p, BorderLayout.CENTER);
        
        // get the frame ready to show
        win.validate();
        win.setVisible(true);
        win.toFront();
    }
    
    // processing the button click
    private void process(){
        
        // get filename from user
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            
            // create a DiamondChain and display results
            try {
                DiamondChain dc = new DiamondChain(f);
                String results = buildDisplay(dc);
                text.setText("File:\t" + f + "\n\n");
                text.append(results);
            } catch (FileNotFoundException e){
                text.setText("Sorry, file not found\nPlease try again");
            }catch (IllegalStateException e) {
                text.setText("Sorry, file must have at least 2 diamonds\nPlease try again");
            }
        } 
    }
    
    // build & return String for display using information from dc
    private String buildDisplay(DiamondChain dc) throws FileNotFoundException {
        String output = "";
        
        Diamond[] far = dc.getFarthest();
        boolean[] increasing = dc.increasingLength();
        Diamond[] originOrdered = dc.originOrder();
      
        output += "Number of diamonds =  " + dc.getCount() + '\n';
        output += "Increasing length:\n" + java.util.Arrays.toString(increasing) + "\n\n";
        output += "Diamonds that are the farthest apart = \n";
        output += "\t[0] " + far[0] + "\n\t[1] " + far[1] + "\n";
        output += "\tdistance = " + far[0].distance(far[1]) + "\n\n";
        output += "Origin ordering length = " + originOrdered.length +"\n";
        output += java.util.Arrays.toString(originOrdered) + "\n\n";
        
        output += "\n\nDiamond Methods: \n";
        output += "\tfar[0].area() = " + far[0].area() + "\n";
        output += "\tfar.[0].perimeter() = " + far[0].perimeter() + "\n";
        
        CSC142Point[] corners = far[0].getCorners();
        
        output += "\nCorners: " + java.util.Arrays.toString(corners) + "\n\n";
        
        output += "\t"+ far[0] + " contains (1,2)? " + far[0].contains(1, 2) + "\n";

        output += "\n\nData Set\n------------\n" + dc;
      
        return output;
        
    }

    public static void main(String [] args) {
         //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DiamondApp b = new DiamondApp();
            }
        });
    }

}