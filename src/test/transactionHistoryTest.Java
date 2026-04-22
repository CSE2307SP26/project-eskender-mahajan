package test;
import main.BankAccount;
import main.TransactionHistory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class transactionHistoryTest {
    ///bank acc has history of transactions, deposits and withdrawals.
    @Test
    void emptyAccount () {
        BankAccount account = new BankAccount(0);
        TransactionHistory transactionHistory = new TransactionHistory(account);
        assertEquals(0, transactionHistory.returnTransactionHistory().length);
    }
     
	///
    @Test
    void depositAccount () {
        BankAccount account = new BankAccount(0);
        TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);
        assertEquals(200, transactionHistory.returnTransactionHistory()[0]);
    }
    ///withdrawal records as negative number in transaction history 
    @Test
    void withdrawalAccount () {
        BankAccount account = new BankAccount(0);
        TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);
        transactionHistory.withdrawal(100);
        assertEquals(200, transactionHistory.returnTransactionHistory()[0]);
        assertEquals(-100, transactionHistory.returnTransactionHistory()[1]);
    }

     ///withdrawal exceeds balance it should not be recorded 
    @Test
    void illegalWithdrawals () {
        BankAccount account = new BankAccount(0);
        TransactionHistory transactionHistory = new TransactionHistory(account);
        transactionHistory.deposit(200);

        assertThrows(IllegalArgumentException.class, () -> {
            transactionHistory.withdrawal(400);
        });

        assertEquals(1, transactionHistory.returnTransactionHistory().length);
    }
}