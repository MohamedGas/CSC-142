/**
 * Class Life is the model (data structure) that holds and updates the
 * status of our cellular automaton game.  It provides methods to initialize
 * the game (done automatically when the game is first created), update one generation
 * and access the game status, which can be used by client code to display
 * the game board and the state of the game
 * 
 * @author  Barbara Goldner, based on work by Hal Perkins.  

 */
public class LifeModel {
     

    /** Number of rows/columns in Life Grid  */
    public static final int NROWSCOLS = 23;

    // private instance variables
    private LifeState[][] board; // game board
    private int generations; //  generations have happened
    private LifeState[][] states;
    private LifeState[] cellCheckerArray = {}; 

    /** Construct and initialize new game board
     */
    public LifeModel() {
        board = new LifeState[NROWSCOLS][NROWSCOLS];
        states = new LifeState[NROWSCOLS][NROWSCOLS];
        newGame();
    }

    /** initialize new game
     * */
    public void newGame() {
        /*****************************************************
         *  STUDENTS:  setup your initial Life environment here
         *****************************************************/

        for (int row = 0; row < NROWSCOLS; row++) {
            for (int col = 0; col < NROWSCOLS; col++) {
                board[row][col] = LifeState.DEAD;
            }
        }
        blinker(); // blinker method 
        topRight(); // Edge Right
        bottonLeft(); //  Edge Left
        trafficLight(); // traffic light pattern

        //Assign secondary newStates array to match the board.

        for (int row = 0; row < NROWSCOLS; row++) {
            for (int col = 0; col < NROWSCOLS; col++) {
                states[row][col] = board[row][col];
            }
        }

    }

    /** Returns the number of generations
     * @return The number of generations that have been run so far.
     */
    public int getGenerationCount() {
        return generations;
    }

    /** Return the current state of game board cell at given row/column
     *  (Squares numbered from 0 to NROWSCOLS-1). 
     *  @throws IllegalArgumentException for bad row/col 
     *  @param row The row of the deisred cell.
     *  @param col The column of the desired cell.
     */
    public LifeState getCell(int row, int col) {

        return board[row][col];

        // stub value
        /***************************************
         *  STUDENTS: fix this 
         **************************************/

    }

    /** Process one life cycle of the cellular automaton
     * 
     */
    public void oneCycle() {
        /***************************************
         *  STUDENTS: implement this 
         **************************************/

        //Calculate next state of the board
        for (int row = 0; row < NROWSCOLS; row++) {
            for (int col = 0; col < NROWSCOLS; col++) {

                states[row][col] = cellChecker(row, col);
            }
        }

        //Assign the next state of the board
        for (int row = 0; row < NROWSCOLS; row++) {
            for (int col = 0; col < NROWSCOLS; col++) {
                this.board[row][col] = states[row][col];

            }
        }
        generations += 1;

    }

    // Helper method for lifeCycle() above. Does the calculation per cell to determine it's next state.
    private LifeState cellChecker(int x, int y) {
        //board[i][k] = center. Need to check all surrounding cells.
        int nearbyAlive = 0;

        //MIDDLE CELLS ***ONLY STRUCTURE PART OF THE ASSIGNMENT***
        if (x > 0 && x < NROWSCOLS - 1 && y > 0 && y < NROWSCOLS - 1) {
            middleCell(x, y);
        }

        //Below is the decision structure for calculating corner cells and edge cells if you want to utilize it.

        //CORNERS
        if (x == 0 && y == 0) {
            //Upper left corner
            upperLeftCorner(x, y);

        } else if (x == 0 && y == NROWSCOLS - 1) { //Upper right corner
            upperRightCorner(x, y);

        } else if (x == NROWSCOLS - 1 && y == 0) { //Lower left corner
            lowerLeftCorner(x, y);

        } else if (x == NROWSCOLS - 1 && y == NROWSCOLS - 1) { //Lower right corner
            lowerRightCorner(x, y);

        }
        //EDGES
        else if ((y == 0) && (x != 0 || x != NROWSCOLS - 1)) {
            //Left edges
            leftEdge(x, y);

        } else if ((y == NROWSCOLS - 1) && (x != 0 || x != NROWSCOLS - 1)) {
            //Right edges
            rightEdge(x, y);

        } else if ((x == 0) && (y != 0 || y != NROWSCOLS - 1)) { //Top edges
            topEdge(x, y);

        } else if ((x == NROWSCOLS - 1) && (y != 0 || y != NROWSCOLS - 1)) {
            //Bottom edgesState  
            bottomEdge(x, y);

        }
        //check if the cell is alive
        for (int j = 0; j < cellCheckerArray.length; j++) {
            if (cellCheckerArray[j] == LifeState.ALIVE) {
                nearbyAlive += 1;
            }
        }

        //Determines the next state of the cell, replace it to states[x][y].
        if (nearbyAlive == 3) { //Birth
            states[x][y] = LifeState.ALIVE;

        } else if ((nearbyAlive <= 3 && nearbyAlive >= 2) && board[x][y] == LifeState.ALIVE) {
        	//Survival

        } else if (nearbyAlive <= 1 || nearbyAlive >= 4) { 
        	//Loneliness & Overcrowding
            states[x][y] = LifeState.DEAD;

        }
        return states[x][y];
    }

    /**
     * this method displays blinker
     */
    public void blinker() {
        //Blinker in the top left.
        board[1][2] = LifeState.ALIVE;
        board[2][2] = LifeState.ALIVE;
        board[3][2] = LifeState.ALIVE;

    }
    /**
     * this method displays topRight shape
     */
    public void topRight() {

        //Block in the top right.
        board[1][17] = LifeState.ALIVE;
        board[1][16] = LifeState.ALIVE;
        board[2][17] = LifeState.ALIVE;
        board[2][16] = LifeState.ALIVE;

    }
    /**
     * this method displays bottomLeft shape
     */
    public void bottonLeft() {
        //Glider in bottom left.
        board[17][3] = LifeState.ALIVE;
        board[16][3] = LifeState.ALIVE;
        board[15][3] = LifeState.ALIVE;
        board[15][2] = LifeState.ALIVE;
        board[16][1] = LifeState.ALIVE;

    }
    /**
     * this method displays traffic light shape
     */
    public void trafficLight() {
        //Center piece splits into traffic light.
        board[8][10] = LifeState.ALIVE;
        board[9][10] = LifeState.ALIVE;
        board[9][11] = LifeState.ALIVE;
        board[10][10] = LifeState.ALIVE;
    }
    /**
     * middle cell shape
     * @param x
     * @param y
     */
    public void middleCell(int x, int y) {
        LifeState cell1 = board[x - 1][y - 1];
        LifeState cell2 = board[x - 1][y];
        LifeState cell3 = board[x - 1][y + 1];
        LifeState cell4 = board[x][y - 1];
        //Cell5 in the middle of a 3x3 square of cells.
        LifeState cell6 = board[x][y + 1];
        LifeState cell7 = board[x + 1][y - 1];
        LifeState cell8 = board[x + 1][y];
        LifeState cell9 = board[x + 1][y + 1];
        cellCheckerArray = new LifeState[] {
            cell1,
            cell2,
            cell3,
            cell4,
            cell6,
            cell7,
            cell8,
            cell9
        };
    }

    //Corners
    /**
     * upper left corner Shape
     * @param x
     * @param y
     */
    public void upperLeftCorner(int x, int y) {
        LifeState cell6 = board[x][y + 1];
        LifeState cell8 = board[x + 1][y];
        LifeState cell9 = board[x + 1][y + 1];
        cellCheckerArray = new LifeState[] {
            cell6,
            cell8,
            cell9
        };
    }
    /**
     * upper right corner Shape
     * @param x
     * @param y
     */
    public void upperRightCorner(int x, int y) {
        LifeState cell4 = board[x][y - 1];
        LifeState cell7 = board[x + 1][y - 1];
        LifeState cell8 = board[x + 1][y];
        cellCheckerArray = new LifeState[] {
            cell4,
            cell7,
            cell8
        };
    }
    /**
     * lower right corner shape
     * @param x
     * @param y
     */
    public void lowerRightCorner(int x, int y) {
        LifeState cell1 = board[x - 1][y - 1];
        LifeState cell2 = board[x - 1][y];
        LifeState cell4 = board[x][y - 1];
        cellCheckerArray = new LifeState[] {
            cell1,
            cell2,
            cell4
        };

    }
    /**
     * lower left corner shape
     * @param x
     * @param y
     */
    public void lowerLeftCorner(int x, int y) {
        LifeState cell2 = board[x - 1][y];
        LifeState cell3 = board[x - 1][y + 1];
        LifeState cell6 = board[x][y + 1];
        cellCheckerArray = new LifeState[] {
            cell2,
            cell3,
            cell6
        };
    }
    //Edges
    /**
     * right edge shape
     * @param x
     * @param y
     */
    public void rightEdge(int x, int y) {
        LifeState cell1 = board[x - 1][y - 1];
        LifeState cell2 = board[x - 1][y];
        LifeState cell4 = board[x][y - 1];
        LifeState cell7 = board[x + 1][y - 1];
        LifeState cell8 = board[x + 1][y];
        cellCheckerArray = new LifeState[] {
            cell1,
            cell2,
            cell4,
            cell7,
            cell8
        };
    }
    /**
     * left edge shape
     * @param x
     * @param y
     */
    public void leftEdge(int x, int y) {
        LifeState cell2 = board[x - 1][y];
        LifeState cell3 = board[x - 1][y + 1];
        LifeState cell6 = board[x][y + 1];
        LifeState cell8 = board[x + 1][y];
        LifeState cell9 = board[x + 1][y + 1];
        cellCheckerArray = new LifeState[] {
            cell2,
            cell3,
            cell6,
            cell8,
            cell9
        };
    }
    /**
     * bottom edge shape
     * @param x
     * @param y
     */
    public void bottomEdge(int x, int y) {
        LifeState cell1 = board[x - 1][y - 1];
        LifeState cell2 = board[x - 1][y];
        LifeState cell3 = board[x - 1][y + 1];
        LifeState cell4 = board[x][y - 1];
        LifeState cell6 = board[x][y + 1];
        cellCheckerArray = new LifeState[] {
            cell1,
            cell2,
            cell3,
            cell4,
            cell6
        };
    }
    /**
     * top edge shape
     * @param x
     * @param y
     */
    public void topEdge(int x, int y) {
        LifeState cell4 = board[x][y - 1];
        LifeState cell6 = board[x][y + 1];
        LifeState cell7 = board[x + 1][y - 1];
        LifeState cell8 = board[x + 1][y];
        LifeState cell9 = board[x + 1][y + 1];
        cellCheckerArray = new LifeState[] {
            cell4,
            cell6,
            cell7,
            cell8,
            cell9
        };
    }
}