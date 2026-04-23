package test;

import main.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PinNumberTest {

    @Test
    void newCustomerHasApinNumber() {
        Customer customer = new Customer("Mohini", 1111);
        assertEquals(1111, customer.getPinNumber());
    }
    @Test
    void customerCanResetPin() {
        Customer customer = new Customer("Alice", 1111);
        customer.resetPin(2222);
        assertEquals(2222, customer.getPinNumber());
    }
}
