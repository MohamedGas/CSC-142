/**
 * A version of a bank account that assesses a service 
 * charge when a minumum amount has been breached.  
 * 
 * @author CSC 142
 */
public class CheckingAccount extends BankAccount {
    
    // instance variables
    private double lowBalance;      // the lowest balance since account opened or when
    // last service charge was deducted
    
    /**
     * Construct a new CheckingAccount with the given name, account number,
     * and initial balance
     * @throws IllegalArgumentException if  initialBalance < 0
     */
    public CheckingAccount(String name, String number, double initialBalance){
    	super(name, number, initialBalance);
    	lowBalance=0;
        
        //Left as an exercise for you
        
    }
    
    /**
     * Withdraw money from this account
     * @param request amount to be withdrawn
     * @throws IllegalArgumentException if amount <0 or amount > balance
     */
    @Override
    public void withdraw(double request) {
        // think about what this does.  How is it the same as the inherited version
        // how does it differ? What about updating that new instance variable?
        super.withdraw(request);
        
        
        
        
        
    }
    /**
     * Deduct a service charge if the account balance has gotten too low
     * since the last time a service charge was deducted (or the account
     * created, whichever comes first).
     * 
     * @param  minBalance minimum account balance before service 
     *         charge applies
     * @param  serviceCharge amount to deduct if charge applies
     */
    public void deductServiceCharge(double minBalance, double serviceCharge){
        if (this.lowBalance < minBalance) {
            this.withdraw(serviceCharge);
        }
        // update the instance variable.  The current balance is now the lowest
        // so far
        lowBalance = this.getBalance();
    }
    
   
    /**
     * returns String representation of this CheckingAccount
     */
    @Override
    public String toString() {
        String output = super.toString();
        output = output.substring(4);
        output = "Checking" + output;
        return output;
    }
    
    // trace through this code
    public static void main(String[] args) {
        CheckingAccount c = new CheckingAccount("Sally", "2", 500);
        
        LimitAccount la = new LimitAccount("Mohamed", "2", 500);
        la.withdraw(50);
        System.out.println(la.getNumberOfWithDraw());
        la.withdraw(50);
        System.out.println(la.getNumberOfWithDraw());
         
        System.out.println(la.getBalance());
//        c.deposit(40);
//        System.out.println(c.getBalance());
//        double b = c.getBalance();
//        c.withdraw(250);
//        System.out.println(c.getBalance());
//        c.deductServiceCharge(300, 7.50);
//        System.out.println(c.getBalance());
//        b = c.getBalance();
//        System.out.println(c.getBalance());
    }
}