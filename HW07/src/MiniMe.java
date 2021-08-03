import java.awt.Color;

 
public class MiniMe extends MashUpPlayer   {

	private Color color;
	private String s;
	
	public MiniMe() {
		super("M", Color.green);
		 
		 
	}
	@Override
	
    public  Action getMove(MashUpPlayerInfo info)
    {
		 
		Direction dir = info.getDirection();
		Neighbor neighborFront = info.getFront();
		 
		
		Action action = null;
//
//		if(dir== Direction.EAST)
//		{
//			if(neighbor == Neighbor.EMPTY)
//			{
//				action = Action.MOVE;
//				
//			}
//			else if ( neighbor == Neighbor.WALL )
//			{ 	  
//				
//				 action = Action.RIGHT;
//				   
//				 }
//					 
//				  
//			
//			else if(neighbor== Neighbor.SAME)
//			{
//				action = Action.RIGHT;
//					
//			}
//			else if(neighbor  == Neighbor.OTHER)
//			{
//				action = Action.FIGHT;
//				
//				 
//			}
//			 
//		}
		 
		
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
