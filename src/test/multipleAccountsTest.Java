package test;
import main.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class MultipleAccountsTest{
    //A bank customer should be able to create an additional account with the bank.
        
    //New customer should have 1 bank account
    @Test
	void newCustomerOpen () {
		Customer newCustomer = new Customer("Mohini");
		assertEquals(1, newCustomer.getAccounts().size());
	}
    //A customer creates an additional bank account
    @Test
	 void oneAccount () {
		Customer newCustomer = new Customer("Mohini");
        newCustomer.createBankAccount();
		assertEquals(2, newCustomer.getAccounts().size());
	}

}