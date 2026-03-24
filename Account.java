public class Account {
    private double balance; 

    public Account(double startingBalance){
        this.balance = startingBalance; 
    }

    public double getBalance(){
        return balance; 
    }

     public void withdraw(double amount){ 
        if(amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive."); ///throws an except error negative money
        }
        if (amount> balance){
            throw new IllegalArgumentException("Insufficient funds."); /// throws an exception error not enough money 
        }

        balance -= amount; 
     }
}
