package main;
public class Account {
    private double balance;

    public Account(double startingBalance) {
        this.balance = startingBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        balance -= amount;
    }
}