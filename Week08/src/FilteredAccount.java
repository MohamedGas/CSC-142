class FilteredAccount extends Account
    
{
    private double zerotransations;
    private double nonZeroTrans;
   
    public FilteredAccount(Client c)
    {
    	
        super(c);
        
        
        
       zerotransations=0;
       nonZeroTrans=0;
        
    }
    @Override
    public boolean process ( Transaction t)
    {
    	nonZeroTrans++;
         if (t.value() == 0) {
        	 zerotransations++; 
             return true;
         } else {
             return super.process(t);
         }
    	
    }
    public double percentFiltered()
    {
    	 if (nonZeroTrans == 0) {
             return 0.0;
         }
         return zerotransations * 100.0 / nonZeroTrans;
     } 
    
}