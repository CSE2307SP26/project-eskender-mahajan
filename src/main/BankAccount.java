package main;

import java.util.ArrayList;

public class BankAccount {
    protected double balance;
    private ArrayList<Double> transactionHistory;
    

    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        if(amount<=0){
            throw new IllegalArgumentException("Deposit can not be negative");
        }
        balance+= amount;
        transactionHistory.add(amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        balance -= amount;
        transactionHistory.add(-amount);
    }
    public ArrayList<Double> returnTransactionHistory(){
        return transactionHistory;
    }
}