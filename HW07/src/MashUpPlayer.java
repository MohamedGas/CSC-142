
import java.awt.*;
/** 
 * This is the superclass of all of the MashUpPlayer classes.  It keeps track of color 
 * String representation. Some methods must be overriden.
 * 
 * The class provides several kinds of constants:<p>
 * type Neighbor  : WALL, EMPTY, SAME, OTHER<br>
 * type Action    : MOVE, LEFT, RIGHT, FIGHT<br>
 * type Direction : NORTH, SOUTH, EAST, WEST<br><br> </p>
 * 
 * Based on work by Stuart Reges and Marty Stepp                                      
 */

public abstract class MashUpPlayer {

    private String myDisplay;
    private Color myColor;
    
    /**
     * Initializes this MashUpPlayer's state
     * @param s this MashUpPlayer's initial String representation
     * @param c this MashUpPlayer's starting color
     */
    public MashUpPlayer(String s, Color c){
        myDisplay = s;
        myColor = c;
    }
    
    /**
     * This method answers this MashUpPlayer's color
     * @return the current color
     */
    public Color getColor(){
        return myColor;
    }

    /**
     * This method answers this MashUpPlayer's String representation
     * @return the current string
     */
    public String toString(){
        return myDisplay;
    }
    
    /**
     * This method allows subclasses only to change this MashUpPlayer's color
     * @param c the new color
     */
    protected void setColor(Color c){
        myColor = c;
    }
    
    /**
     * This method allows subclasses only to change this MashUpPlayer's String display
     * @param s the new display
     */
    protected void setDisplay(String s){
        myDisplay = s;
    }

    /**
     * This method answers this MashUpPlayer's Action
     * MUST BE OVERRIDDEN IN SUBCLASSES
     *  
     * @param info information about this MashUpPlayer in the simulation
     * @return the current Action
     */
    public abstract Action getMove(MashUpPlayerInfo info);

    /**
     * <div>
     * WALL: against the wall of the simulation world<br>
     * EMPTY: the neighboring spot is empty<br>
     * SAME: an MashUpPlayer of the same species<br>
     * OTHER: an MashUpPlayer of another species<br></div>
     */
    public static enum Neighbor {
        WALL, EMPTY, SAME, OTHER
    };

    /**
     * <div>
     * MOVE: move one space in the current direction<br>
     * LEFT: turn left by rotating 90 degrees counter-clockwise<br>
     * RIGHT: turn right by rotating 90 degrees clockwise<br>
     * FIGHT: fight the MashUpPlayer in front of you</div>
     */
    public static enum Action {
        MOVE, LEFT, RIGHT, FIGHT
    };

    /**
     * <div>
     * NORTH<br>
     * SOUTH<br>
     * EAST<br>
     * WEST</div>
     */
    public static enum Direction {
        NORTH, SOUTH, EAST, WEST
    };
    
    // This prevents any MashUpPlayer from trying to redefine the definition of
    // object equality, which is important for the simulator to work properly.
    public final boolean equals(Object other) {
        return this == other;
    }
}