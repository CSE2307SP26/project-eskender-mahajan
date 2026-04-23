package test;
import main.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class MultipleAccountsTest{
    @Test
	void newCustomerOpen () {
		Customer newCustomer = new Customer("Mohini",1111);
		assertEquals(2, newCustomer.getAccounts().size());
	}
    //A customer creates an additional bank account
    @Test
	 void oneAccount () {
		Customer newCustomer = new Customer("Mohini",1111);
        newCustomer.createBankAccount();
		assertEquals(3, newCustomer.getAccounts().size());
	}

}