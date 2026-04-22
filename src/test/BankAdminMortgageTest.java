package test;

import main.BankAdmin;
import main.Customer;
import main.MortgageApplication;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAdminMortgageTest {

    @Test
    void adminCanAddMortgageApplication() {
        BankAdmin admin = new BankAdmin("Admin", 1234);
        Customer customer = new Customer("Bob");
        MortgageApplication application = new MortgageApplication(customer, 200000, 20);

        admin.addMortgageApplication(application);

        assertEquals(1, admin.getMortgageApplications().size());
    }

    @Test
    void adminCanDenyMortgageApplication() {
        BankAdmin admin = new BankAdmin("Admin", 1234);
        Customer customer = new Customer("Bob");
        MortgageApplication application = new MortgageApplication(customer, 200000, 20);

        admin.addMortgageApplication(application);
        admin.denyMortgageApplication(0);

        assertEquals("Denied", admin.getMortgageApplications().get(0).getStatus());
    }
}