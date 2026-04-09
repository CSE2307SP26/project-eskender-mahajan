package test;
import main.BankAccount;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void startingBalance() {
        BankAccount account = new BankAccount(200);
        assertEquals(200, account.getBalance());
    }

    @Test
    void withdrawValidAmount() {
        BankAccount account = new BankAccount(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void multipleWithdrawals() {
        BankAccount account = new BankAccount(200);
        account.withdraw(40);
        account.withdraw(50);
        assertEquals(110, account.getBalance());
    }

    @Test
    void withdrawTooMuch() {
        BankAccount account = new BankAccount(300);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(400);
        });
    }

    @Test
    void invalidWithdrawalAmount() {
        BankAccount account = new BankAccount(200);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
}