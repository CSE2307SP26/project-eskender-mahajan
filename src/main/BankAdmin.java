package main;

import java.util.ArrayList;

public class BankAdmin {
    private String name;
    private ArrayList<Customer> bankCustomers;
    
    public BankAdmin(String name){
        this.name = name;
        bankCustomers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers(){
        return bankCustomers;
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

