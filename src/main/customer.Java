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
}