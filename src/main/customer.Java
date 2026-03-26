package main;
import java.util.ArrayList;
public class Customer{
    private ArrayList<BankAccount> accounts;

    public Customer(){
        accounts = new ArrayList<>();
    }

    public ArrayList<BankAccount>getAccounts(){
        return accounts;
    }

    public void createBankAccount(){
        accounts.add(new BankAccount(0.0));
    }
}