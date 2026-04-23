package test;

import main.BankAccount;
import main.Customer;
import main.Transfer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TransactionHistoryTest {

    @Test
    void emptyAccount() {
        Customer newCustomer = new Customer("Mohini", 1111);
        BankAccount account = newCustomer.getAccounts().get(0);
        assertEquals(0, account.returnTransactionHistory().size());
    }

    @Test
    void depositAccount() {
        Customer newCustomer = new Customer("Mohini", 1111);
        BankAccount account = newCustomer.getAccounts().get(0);
        account.deposit(200);
        assertEquals(200, account.returnTransactionHistory().get(0), 0.001);
    }

    @Test
    void withdrawalAccount() {
        Customer newCustomer = new Customer("Mohini", 1111);
        BankAccount account = newCustomer.getAccounts().get(0);
        account.deposit(200);
        account.withdraw(100);
        assertEquals(200, account.returnTransactionHistory().get(0), 0.001);
        assertEquals(-100, account.returnTransactionHistory().get(1), 0.001);
    }

    @Test
    void illegalWithdrawals() {
        Customer newCustomer = new Customer("Mohini", 1111);
        BankAccount account = newCustomer.getAccounts().get(0);
        account.deposit(200);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(400);
        });
    }

    @Test
    void smallTransferExecutesImmediately() {
        Customer customer = new Customer("Alice", 1111);
        BankAccount savings = customer.getAccounts().get(0);
        BankAccount checking = customer.getAccounts().get(1);
        savings.deposit(500.0);
        Transfer result = customer.requestTransfer(savings, checking, 100.0, "rent");
        assertNull(result);
        assertEquals(400.0, savings.getBalance(), 0.001);
        assertEquals(100.0, checking.getBalance(), 0.001);
    }

    @Test
    void largeTransferRequiresAdminApproval() {
        Customer customer = new Customer("Alice", 1111);
        BankAccount savings = customer.getAccounts().get(0);
        BankAccount checking = customer.getAccounts().get(1);
        savings.deposit(20000.0);
        Transfer result = customer.requestTransfer(savings, checking, 15000.0, "big transfer");
        assertNotNull(result);
        assertEquals(20000.0, savings.getBalance(), 0.001);
    }
}
