import java.awt.*;
import java.awt.event.*;

/**
 * This class provides the display representation of a single cell
 * on the Life game board. 
 * 
 * @author Barbara Goldner
 */

public class Cell extends Panel  {

    private LifeState state;    // Contents of this square (LifeState.DEAD, etc.)
    private int row;            // Row of this square on the game board    
    private int col;            // Column of this square on the game board

    /** Initialize this Cell to the given state, and remember the row and
     *  column number locating this square on the Life game board. 
     *  @param row must be between 0 and Board.NROWSCOLS - 1
     *  @param col must be between 0 and Board.NROWSCOLS - 1
     *  @param state must be either Life.DEAD, or Life.ALIVE
     *  @throws IllegalArgumentException if bad input
     *  */

    public Cell(LifeState state, int row, int col) {
        if ( row < 0 || row >=LifeModel.NROWSCOLS ||
             col < 0 || col >= LifeModel.NROWSCOLS)
             throw new IllegalArgumentException("Bad row or column");
        if ( state != LifeState.ALIVE &&
             state != LifeState.DEAD)
             throw new IllegalArgumentException("Bad state");
        this.state = state;
        this.row = row;
        this.col = col;
    }

    /** Change state of this square to the given argument.
     * @param state must be Life.DEAD or Life.ALIVE
     * @throws IllegalArgumentException if bad argument 
     * */

    public void setState(LifeState state) {
        if ( state != LifeState.ALIVE &&
             state != LifeState.DEAD)
             throw new IllegalArgumentException("Bad state");
        LifeState oldstate = this.state;
        this.state = state;
       // Repaint only if state changes to minimize flicker.
        if (oldstate != state) {
            this.repaint();
        }
    }

    /** Paint this cell when requested */
    public void paint(Graphics g) {
        super.paint(g);
        Color c = new Color(0,220,240);
        g.setColor(c);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawRect(0, 0, getWidth() - 1, getHeight()- 1);
        if(state == LifeState.ALIVE) {
            g.setColor(Color.white);
            g.fillOval(5, 5, getWidth() - 10, getHeight() - 10);
        } 
    }
}