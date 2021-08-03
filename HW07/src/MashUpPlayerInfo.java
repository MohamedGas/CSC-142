
/**
 * The MashUpPlayerInfo interface defines a set of methods for querying the
 * state of a MashUpPlayer object in the simulation. 
 * 
 * Based on work by Stuart Reges and Marty Stepp
 */

public interface MashUpPlayerInfo {
    /**
     * returns the neighbor in front of a specific MashUpPlayer
     */
    public MashUpPlayer.Neighbor getFront();
    
    /**
     * returns the neighbor behind of a specific MashUpPlayer
     */
    public MashUpPlayer.Neighbor getBack();
    
    /**
     * returns the neighbor to the left of a specific MashUpPlayer
     */
    public MashUpPlayer.Neighbor getLeft();
    
    
    /**
     * returns the neighbor to the right of a specific MashUpPlayer
     */
    public MashUpPlayer.Neighbor getRight();
    
    
    /**
     * returns the direction a specific MashUpPlayer is facing in the simulation
     */
    public MashUpPlayer.Direction getDirection();
    
    /**
     * returns the number of entities a specific MashUpPlayer has infected
     */
    public int getFightCount();
}
