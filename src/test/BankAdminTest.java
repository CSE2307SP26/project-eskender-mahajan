package test;
import main.BankAccount;
import main.BankAdmin;
import main.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BankAdminTest {
    
    @Test
    void viewOneCustomerAccount(){
        BankAdmin administrator = new BankAdmin("Bank Admin",1111);
        Customer customer = new Customer("Mohini",1111);
        administrator.addCustomer(customer);
        assertEquals(1, administrator.getCustomers().size());
    }

    @Test
    void viewCustomerBalance(){
        BankAdmin administrator = new BankAdmin("Bank Admin",1111);
        Customer customer = new Customer("Mohini",1111);
        BankAccount account = customer.getAccounts().get(0);
        account.deposit(100);
        double balance = administrator.getCustomerBalance(account);
        assertEquals(100, balance);
    }
    @Test
    void adminCanDeleteCustomer() {
        BankAdmin admin = new BankAdmin("Admin", 9999);
        Customer customer = new Customer("Alice", 1111);
        admin.addCustomer(customer);
        admin.deleteCustomerAccount(customer);
        assertEquals(0, admin.getCustomers().size());
}
}
