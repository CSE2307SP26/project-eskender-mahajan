package main;

import java.util.ArrayList;

public class BankAdmin {
    private String name;
    private ArrayList<Customer> bankCustomers;
    private int pinNumber;
    
    public BankAdmin(String name, int pinNumber){
        this.name = name;
        this.pinNumber = pinNumber;
        bankCustomers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers(){
        return bankCustomers;
    }
    public void addCustomer(Customer customer){
        bankCustomers.add(customer);
    }
    public Customer getCustomerFromName(String name){
        for(int i = 0;i<bankCustomers.size();i++){
            if(bankCustomers.get(i).getName().equals(name)){
                    return bankCustomers.get(i);
            }
        }
        return null;
    }
    public ArrayList<BankAccount> getCustomerAccounts(Customer customer){
        for(int i = 0;i<bankCustomers.size();i++){
            if(bankCustomers.get(i)==customer){
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
        for(int i = 0;i<bankCustomers.size();i++){
            if(bankCustomers.get(i)==customer){
                    bankCustomers.remove(i);
            }
            }
        }
    }

