package main;
import java.util.ArrayList;
public class Customer{
    private ArrayList<BankAccount> accounts;
    ///mortage application array list
    private ArrayList<MortgageApplication> mortgageApplications; 
    private String name;

    public Customer(String name){
        accounts = new ArrayList<>();
        this.name = name;
        mortgageApplications = new ArrayList<>(); //initalize mortage application array list :) 
       /// accounts.add(new BankAccount(0.0));
    }
    public String getName(){
        return name;
    }
 
    public void createBankAccount(){
        accounts.add(new BankAccount(0.0));
    }

    /// mortgage addtions under here 
       public ArrayList<BankAccount> getAccounts(){
        return accounts;
    }

    public void applyForMortgage(double amount, int years){ 
        MortgageApplication application = new MortgageApplication(this, amount, years); 
        mortgageApplications.add(application); 
    }

    public ArrayList<MortgageApplication> getMortgageApplications(){ 
        return mortgageApplications;
    }

}