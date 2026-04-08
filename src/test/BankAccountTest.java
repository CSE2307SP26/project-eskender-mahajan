package test;
import main.BankAccount;
import main.Customer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void startingBalance() {
        Customer customer = new Customer("Beamlak");
        BankAccount account = customer.getAccounts().get(0);
        assertEquals(0.0, account.getBalance(),0.001);
    }

    @Test
    void withdrawValidAmount() {
        Customer customer = new Customer("Mohini");
        BankAccount account = customer.getAccounts().get(0);
        account.deposit(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance(),0.001);
    }

    @Test
    void multipleWithdrawals() {
        Customer customer = new Customer("Beamlak");
        BankAccount account = customer.getAccounts().get(0);
        account.deposit(200);
        account.withdraw(40);
        account.withdraw(50);
        assertEquals(110, account.getBalance(),0.001);
    }

    @Test
    void withdrawTooMuch() {
        Customer customer = new Customer("Mohini");
        BankAccount account = customer.getAccounts().get(0);
        account.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
    }

    @Test
    void invalidWithdrawalAmount() {
        Customer customer = new Customer("Beamlak");
        BankAccount account = customer.getAccounts().get(0);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
}