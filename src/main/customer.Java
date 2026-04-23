package main;
import java.util.ArrayList;
public class Customer{
    private ArrayList<BankAccount> accounts;
    private String name;
    private int pinNumber;

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
    public boolean verifyIdentity(String question, String answer) {
    switch (question) {
        case "1":
            // first transaction in savings account
            ArrayList<Double> history = accounts.get(0).returnTransactionHistory();
            if (history.isEmpty()) return false;
            return String.valueOf(history.get(0)).equals(answer);
        case "2":
            return String.valueOf(accounts.size()).equals(answer);
        case "3":
            return String.valueOf(accounts.get(0).getBalance()).equals(answer);
        default:
            return false;
    }
}

public void resetPin(int newPin) {
    this.pinNumber = newPin;
}
}