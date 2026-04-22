package main;

import java.util.ArrayList;

///new changes
public class BankAdmin {
    private String name;
    private ArrayList<Customer> bankCustomers;
    private int pinNumber;
    private ArrayList<MortgageApplication> mortgageApplications;
    
    ///constructor
    public BankAdmin(String name, int pinNumber){
        this.name = name;
        this.pinNumber = pinNumber;
        bankCustomers = new ArrayList<>();
        mortgageApplications = new ArrayList<>();
    }
    ///getters and setters
    public ArrayList<Customer> getCustomers(){
        return bankCustomers;
    }

    public void addCustomer(Customer customer){
        bankCustomers.add(customer);
    }

    public Customer getCustomerFromName(String name){
        for(int i = 0; i < bankCustomers.size(); i++){
            if(bankCustomers.get(i).getName().equals(name)){
                return bankCustomers.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<BankAccount> getCustomerAccounts(Customer customer){
        for(int i = 0; i < bankCustomers.size(); i++){
            if(bankCustomers.get(i) == customer){
                return customer.getAccounts();
            }
        }
        return null;
    }

    public double getCustomerBalance(BankAccount account){
        return account.getBalance();
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Double> getCustomerTransactionHistory(BankAccount account){
        return account.returnTransactionHistory();
    }

    public void deleteCustomerAccount(Customer customer){
        for(int i = 0; i < bankCustomers.size(); i++){
            if(bankCustomers.get(i) == customer){
                bankCustomers.remove(i);
            }
        }
    }
/// mortgage application methods
    public void addMortgageApplication(MortgageApplication application){
        mortgageApplications.add(application);
    }

    public ArrayList<MortgageApplication> getMortgageApplications(){
        return mortgageApplications;
    }

    public void denyMortgageApplication(int index){
        if(index < 0 || index >= mortgageApplications.size()){
            throw new IllegalArgumentException("Invalid mortgage application index.");
        }
        mortgageApplications.get(index).deny();
    }

    public void viewMortgageApplications(){
        if(mortgageApplications.isEmpty()){
            System.out.println("No mortgage applications found.");
            return;
        }

        for(int i = 0; i < mortgageApplications.size(); i++){
            System.out.println((i + 1) + ". " + mortgageApplications.get(i));
        }
    }
}