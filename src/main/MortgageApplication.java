package main; 

///third iteration 
public class MortgageApplication{
    private Customer customer;
    private double amount; 
    private int years; 
    private String status; 

    public MortgageApplication(Customer customer, double amount, int years){
        this.customer = customer; 
        this.amount = amount; 
        this.years = years; 
        this.status = "Pending";

    }
    public Customer getCustomer(){
        return customer; 
    }

    public double getAmount(){ 
        return amount; 
    }

    public int getYears(){
        return years; 
    }

    public String getStatus(){
        return status; 
    }

    public void deny(){ 
        status = "Denied";
    }

    @Override
    public String toString(){
        return "Customer: " + customer.getName() + ", Amount: " + amount + ", Years: " + years + ", Status: " + status;
    }
}

