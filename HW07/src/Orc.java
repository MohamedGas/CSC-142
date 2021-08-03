import java.awt.Color;

public class Orc extends MashUpPlayer {

    public Orc() {

        super("//", Color.red);

    }

    @Override
    public Action getMove(MashUpPlayerInfo info) {
        // TODO Auto-generated method stub

        Direction dir = info.getDirection();
        Neighbor neighborFront = info.getFront();
        
        Action action = null;
      
        
       // EAST
        if (dir == Direction.EAST) {

            if (neighborFront == Neighbor.EMPTY) {
                action = Action.MOVE;

            } else if (neighborFront == Neighbor.WALL) {
                //turn around
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }
            } else if (neighborFront == Neighbor.SAME)
            //turn arround if same ORC
            {
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }
            } else if (neighborFront == Neighbor.OTHER) {
                action = Action.FIGHT;

            }

        } 
        //NORTH
        else if (dir == Direction.NORTH) {
            if (neighborFront == Neighbor.EMPTY) {
                action = Action.MOVE;

            } else if (neighborFront == Neighbor.WALL) {
                //turn around
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }
            } else if (neighborFront == Neighbor.SAME) { 
            	//turn around ORC
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }

            } else if (neighborFront == Neighbor.OTHER) {
                action = Action.FIGHT;
            }
        } 
        //WEST
        else if (dir == Direction.WEST) {
            if (neighborFront == Neighbor.EMPTY) {
                action = Action.MOVE;

            } else if (neighborFront == Neighbor.WALL) {
                //turn around
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }
            } else if (neighborFront == Neighbor.SAME) {
                //turn around ORC
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }

            } else if (neighborFront == Neighbor.OTHER) {
                action = Action.FIGHT;
            }
        } 
        
        
        //SOUTH
        else if (dir == Direction.SOUTH) {
            if (neighborFront == Neighbor.EMPTY) {
                action = Action.MOVE;

            } else if (neighborFront == Neighbor.WALL) {
                //turn around
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }
            } else if (neighborFront == Neighbor.SAME) {
                //turn around ORC
                if (info.getRight() == neighborFront.EMPTY)

                {
                    action = Action.RIGHT;

                }
                if (info.getLeft() == neighborFront.EMPTY) {
                    action = Action.LEFT;

                }

            } else if (neighborFront == Neighbor.OTHER) {

                action = Action.FIGHT;
                

            }
            //agressive 
            if (info.getBack() == Neighbor.OTHER || info.getLeft() == Neighbor.OTHER) {
                this.setColor(Color.black);
            }
            if (info.getLeft() == Neighbor.OTHER || info.getBack() == Neighbor.OTHER) {
                this.setColor(Color.black);
            }
            if (info.getRight() == Neighbor.OTHER || info.getBack() == Neighbor.OTHER) {
                this.setColor(Color.black);
            }

        }
        

        return action;
    }
   
}