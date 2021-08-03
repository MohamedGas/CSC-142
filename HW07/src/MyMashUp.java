import java.awt.Color;

 

public class MyMashUp extends MashUpPlayer   {

	private Color color;
	private String s;
	
	public MyMashUp() {
		super("D", Color.BLUE);
		
		 
		 
	}
	@Override
	
    public  Action getMove(MashUpPlayerInfo info)
    {
		 
		Direction dir = info.getDirection();
		Neighbor neighborFront = info.getFront();
		 
		
		Action action = null;
 
		 
		
		if(dir== Direction.EAST)
		{
			
			
			if(neighborFront == Neighbor.EMPTY)
			{
				action = Action.MOVE;
				
			}
			else if ( neighborFront == Neighbor.WALL )
			{
				action = Action.LEFT;
			}
			else if(neighborFront== Neighbor.SAME)
			{
				action = Action.LEFT;
					
			}
			else if(neighborFront == Neighbor.OTHER)
			{
				action = Action.FIGHT;
				
				 
			}
			
			
			 
		}
		
		
		
		else if (dir== Direction.NORTH)
		{
			if(neighborFront == Neighbor.EMPTY)
			{
				action = Action.MOVE;
				
			}
			else if ( neighborFront == Neighbor.WALL )
			{
				action = Action.LEFT;
			}
			else if(neighborFront== Neighbor.SAME)
			{
				action = Action.RIGHT;
					
			}
			else if(neighborFront == Neighbor.OTHER)
			{
				action = Action.FIGHT;
			}
		}
		else if(dir== Direction.WEST)
		{
			if(neighborFront == Neighbor.EMPTY)
			{
				action = Action.MOVE;
				
			}
			else if ( neighborFront == Neighbor.WALL )
			{
				action = Action.LEFT;
			}
			else if(neighborFront== Neighbor.SAME)
			{
				action = Action.RIGHT;
					
			}
			else if(neighborFront == Neighbor.OTHER)
			{
				action = Action.FIGHT;
			}
		}
		else if(dir== Direction.SOUTH)
		{
			if(neighborFront == Neighbor.EMPTY)
			{
				action = Action.MOVE;
				
			}
			else if ( neighborFront == Neighbor.WALL )
			{
				action = Action.LEFT;
			}
			else if(neighborFront== Neighbor.SAME)
			{
				action = Action.RIGHT;
					
			}
			else if(neighborFront == Neighbor.OTHER)
			{
				action = Action.FIGHT;
			}
		}
		 
		 
		
		 
			
		
		 
		return action;
		
    }
	
	
	 
	
	
	

}
