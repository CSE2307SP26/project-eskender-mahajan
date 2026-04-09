package test;
import main.BankAccount;
import main.BankAdmin;
import main.Customer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAdminTest {
    
    @Test
    void viewOneCustomerAccount(){
        BankAdmin administrator = new BankAdmin("Bank Admin");
        Customer customer = new Customer("Mohini");
        assertEquals(1, administrator.getCustomers().size());
    }

    @Test
    void viewCustomerBalance(){
        BankAdmin administrator = new BankAdmin("Bank Admin");
        Customer customer = new Customer("Mohini");
        BankAccount account = customer.getAccounts().get(0);
        account.deposit(100);
        double balance = administrator.getCustomerBalance(account);
        assertEquals(100, balance);
    }
}
