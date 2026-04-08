package test;
import main.BankAccount;
import main.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class TransactionHistoryTest{
    //A bank customer should be able to view their transaction history for an account.
    
    //New customer should have no transaction history
    @Test
	void emptyAccount () {
		Customer newCustomer = new Customer("Mohini");
		BankAccount account = newCustomer.getAccounts().get(0);
		assertEquals(0, account.returnTransactionHistory().size());
	}
    //Deposit into an Account should have a transaction history
    @Test
	 void depositAccount () {
		Customer newCustomer = new Customer("Mohini");
		BankAccount account = newCustomer.getAccounts().get(0);
		account.deposit(200);
		assertEquals(200, account.returnTransactionHistory().get(0),0.001);
	}
    //Withdrawal from an Account should have a transaction history
    @Test
	void withdrawalAccount () {
		Customer newCustomer = new Customer("Mohini");
		BankAccount account = newCustomer.getAccounts().get(0);
		account.deposit(200);
		account.withdraw(100);
		assertEquals(200, account.returnTransactionHistory().get(0),0.001);
		assertEquals(-100, account.returnTransactionHistory().get(1),0.001);
	}
	//Illegal Withdrawls
	@Test
	void illegalWithdrawals () {
		Customer newCustomer = new Customer("Mohini");
		BankAccount account = newCustomer.getAccounts().get(0);
		account.deposit(200);
		assertThrows(IllegalArgumentException.class, () -> {
			account.withdraw(400);
		});
	}
	}