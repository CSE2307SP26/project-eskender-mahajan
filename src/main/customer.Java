package main;
import java.util.ArrayList;
public class Customer{
    private ArrayList<BankAccount> accounts;
    private String name;

    public Customer(String name){
        accounts = new ArrayList<>();
        this.name = name;
       /// accounts.add(new BankAccount(0.0));
    }
    public String getName(){
        return name;
    }
    public ArrayList<BankAccount>getAccounts(){
        return accounts;
    }
    public void createBankAccount(){
        accounts.add(new BankAccount(0.0));
    }
}