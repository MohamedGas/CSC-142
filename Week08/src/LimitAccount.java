
public class LimitAccount extends BankAccount {
	
	private int numberOfWithDraws;
	
	public LimitAccount(String name , String id , double balance)
	{
		super(name, id, balance);
	    resetNumberOfWithDraws();
	 
	}
	
	@Override
	public void withdraw(double amt)
	{
		if (numberOfWithDraws <=0)
		{
			throw new IllegalStateException("You have reached your daily withdraw Limit");
		}
		super.withdraw(amt);
		numberOfWithDraws--;
	}
	 
	
	
	public int getNumberOfWithDraw()
	{
		return numberOfWithDraws;
	}
	public void resetNumberOfWithDraws()
	{
		this.numberOfWithDraws=5;
	}
	
	 
	@Override
	public String toString()
	{
		return "you have " + this.numberOfWithDraws +" available withdraws";
	}
	
	

}
