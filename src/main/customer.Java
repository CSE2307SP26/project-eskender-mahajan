package main;
import java.util.ArrayList;
public class Customer{
    private ArrayList<BankAccount> accounts;
    private String name;
    private int pinNumber;
    private static final double LARGE_TRANSFER_THRESHOLD = 10000.0;

    public Customer(String name,int pinNumber){
        accounts = new ArrayList<>();
        this.name = name;
        accounts.add(new SavingsAccount(0.0,0.1));
        accounts.add(new CheckingAccount(0.0, 10000, 0.01));
        this.pinNumber = pinNumber;
    }
    public String getName(){
        return name;
    }
    public int getPinNumber(){
        return pinNumber;
    }
    public ArrayList<BankAccount>getAccounts(){
        return accounts;
    }
    public void createBankAccount(){
        accounts.add(new BankAccount(0.0));
    }
    public Transfer requestTransfer(BankAccount from, BankAccount to, double amount, String memo) {
        if (!accounts.contains(from) || !accounts.contains(to)) {
            throw new IllegalArgumentException("Both accounts must belong to this customer."); 
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive.");
        }

        if (amount > LARGE_TRANSFER_THRESHOLD) {
            return new Transfer(this, from, to, amount, memo);
        } else {
            from.withdraw(amount);
            to.deposit(amount);
            return null;
        }
}
}