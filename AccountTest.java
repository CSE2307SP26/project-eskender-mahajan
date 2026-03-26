import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void startingBalance() {
        Account account = new Account(200);
        assertEquals(200, account.getBalance());
    }

    @Test
    void withdrawValidAmount() {
        Account account = new Account(200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void multipleWithdrawals() {
        Account account = new Account(200);
        account.withdraw(40);
        account.withdraw(50);
        assertEquals(110, account.getBalance());
    }

    @Test
    void withdrawTooMuch() {
        Account account = new Account(300);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(400);
        });
    }

    @Test
    void invalidWithdrawalAmount() {
        Account account = new Account(200);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }
}