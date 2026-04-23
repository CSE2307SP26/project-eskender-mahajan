package test;

import main.Customer;
import main.MortgageApplication;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerMortgageTest {

    @Test
    void newCustomerStartsWithNoMortgageApplications() {
        Customer customer = new Customer("Bob",1111);

        assertEquals(0, customer.getMortgageApplications().size());
    }

    @Test
    void applyingForMortgageAddsApplication() {
        Customer customer = new Customer("Bob",1111);

        customer.applyForMortgage(300000, 15);

        assertEquals(1, customer.getMortgageApplications().size());
    }

    @Test
    void applyingForMortgageCreatesCorrectApplication() {
        Customer customer = new Customer("Bob",1111);

        customer.applyForMortgage(300000, 15);
        MortgageApplication application = customer.getMortgageApplications().get(0);

        assertEquals(customer, application.getCustomer());
        assertEquals(300000, application.getAmount());
        assertEquals(15, application.getYears());
        assertEquals("Pending", application.getStatus());
    }
}