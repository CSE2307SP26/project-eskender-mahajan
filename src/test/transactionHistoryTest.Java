import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class transactionHistoryTest{
    //A bank customer should be able to view their transaction history for an account.
    
    //New Account should have no transaction history
    @Test
	void emptyAccount () {
		BankAccount account = new BankAccount();
		TransactionHistory transactionHistory = new TransactionHistory(account);
		assertEquals(0, transactionHistory.returnTransactionHistory().length);
	}
    //Deposit into an Account should have a transaction history
    @Test
	 void depositAccount () {
		BankAccount account = new BankAccount();
		TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);
		assertEquals(200, transactionHistory.returnTransactionHistory()[0]);
	}
    //Withdrawal from an Account should have a transaction history
    @Test
	void withdrawalAccount () {
		BankAccount account = new BankAccount();
		TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);
		transactionHistory.withdrawal(100);
		assertEquals(200, transactionHistory.returnTransactionHistory()[0]);
        assertEquals(-100, transactionHistory.returnTransactionHistory()[1]);
	}
	//Illegal Withdrawls
	@Test
	void illegalWithdrawals () {
		BankAccount account = new BankAccount();
        TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);
		transactionHistory.withdrawal(400);
		assertEquals(1, transactionHistory.returnTransactionHistory().length);
	}
}