package main;

public class CheckingAccount extends BankAccount{
    private double overdraftLimit; 
 
    ///Checking acc takes in starting balance and overdraft limit 
    public CheckingAccount(double startingBalance, double overdraftLimit){
        super(startingBalance); 
        this.overdraftLimit = overdraftLimit;
    }

    ////Overrides 
    @Override
    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
         if (amount > getBalance() + overdraftLimit) {
            throw new IllegalArgumentException("Withdrawal amount exceeds overdraft limit.");

         } 
         // If the withdrawal is valid, proceed with the withdrawal
         super.deposit(-amount); // Use deposit with negative amount to update balance and transaction history

    }
  
}