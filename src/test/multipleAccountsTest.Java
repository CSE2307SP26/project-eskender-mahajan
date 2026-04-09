package test;
import main.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class multipleAccountsTest{
    //A bank customer should be able to create an additional account with the bank.
        
    //New customer should have no bank account
    @Test
	void newCustomerOpen () {
		Customer newCustomer = new Customer();
		assertEquals(0, newCustomer.getAccounts().size());
	}
    //A customer creates 1 bank account
    @Test
	 void oneAccount () {
		Customer newCustomer = new Customer();
        newCustomer.createBankAccount();
		assertEquals(1, newCustomer.getAccounts().size());
	}
    //A customer creates 2 bank accounts
    @Test
	void twoAccounts () {
		Customer newCustomer = new Customer();
        newCustomer.createBankAccount();
        newCustomer.createBankAccount();
		assertEquals(2, newCustomer.getAccounts().size());
	}
}