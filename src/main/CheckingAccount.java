package main;

public class CheckingAccount extends BankAccount {
    
    private double overdraftLimit;
    private double interestRate;

    // constructor
    public CheckingAccount(double startingBalance, double overdraftLimit, double interestRate){
        super(startingBalance);
        this.overdraftLimit = overdraftLimit;
        this.interestRate = interestRate;
    }

    // override withdraw
    @Override
    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        if (amount > getBalance() + overdraftLimit) {
            throw new IllegalArgumentException("Withdrawal amount exceeds overdraft limit.");
        }

        super.deposit(-amount);
    }

    // apply interest 
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}
