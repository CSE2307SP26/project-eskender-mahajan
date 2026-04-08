package main;
public class SavingsAccount extends BankAccount{
    private double interestRate; 

    /// saving account takes in starting balance and interest rate 
    public SavingsAccount(double startingBalance, double interestRate){
        super(startingBalance); 
        this.interestRate = interestRate; 
    }
    
    ///applies interest 
    public void applyInterest(){
        double interest = getBalance() * interestRate; 
        deposit(interest); 
    }
}