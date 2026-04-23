package test;

import main.BankAccount;
import main.BankAdmin;
import main.Customer;
import main.MortgageApplication;
import main.Transfer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAdminMortgageTest {

    @Test
    void adminCanAddMortgageApplication() {
        BankAdmin admin = new BankAdmin("Admin", 1234);
        Customer customer = new Customer("Bob", 1234);
        MortgageApplication application = new MortgageApplication(customer, 200000, 20);

        admin.addMortgageApplication(application);

        assertEquals(1, admin.getMortgageApplications().size());
    }

    @Test
    void adminCanDenyMortgageApplication() {
        BankAdmin admin = new BankAdmin("Admin", 1234);
        Customer customer = new Customer("Bob", 1111);
        MortgageApplication application = new MortgageApplication(customer, 200000, 20);

        admin.addMortgageApplication(application);
        admin.denyMortgageApplication(0);

        assertEquals("Denied", admin.getMortgageApplications().get(0).getStatus());
    }

    @Test
    void adminApprovesTransfer() {
        Customer customer = new Customer("Alice", 1111);
        BankAdmin admin = new BankAdmin("Admin", 9999);
        BankAccount savings = customer.getAccounts().get(0);
        BankAccount checking = customer.getAccounts().get(1);
        savings.deposit(20000.0);
        Transfer transfer = customer.requestTransfer(savings, checking, 15000.0, "memo");
        admin.receiveTransferRequest(transfer);
        admin.approveTransfer(transfer);
        assertEquals(5000.0, savings.getBalance(), 0.001);
        assertEquals(15000.0, checking.getBalance(), 0.001);
        assertEquals("APPROVED", transfer.getStatus());
    }

    @Test
    void adminDeniesTransfer() {
        Customer customer = new Customer("Alice", 1111);
        BankAdmin admin = new BankAdmin("Admin", 9999);
        BankAccount savings = customer.getAccounts().get(0);
        BankAccount checking = customer.getAccounts().get(1);
        savings.deposit(20000.0);
        Transfer transfer = customer.requestTransfer(savings, checking, 15000.0, "memo");
        admin.receiveTransferRequest(transfer);
        admin.denyTransfer(transfer);
        assertEquals(20000.0, savings.getBalance(), 0.001);
        assertEquals("DENIED", transfer.getStatus());
    }
}