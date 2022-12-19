package accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    CheckingAccount checkingAccount;

    @BeforeEach
    public void createAccount() {
        checkingAccount = new CheckingAccount(1000, "Ivan");
    }

    @Test
    public void shouldPay() {
        checkingAccount.pay(300);
        long actual = checkingAccount.getBalance();
        Assertions.assertEquals(700, actual);
    }

    @Test
    public void shouldTransfer() {
        SavingAccount savingAccount = new SavingAccount(1000, "Ivan", 200);
        checkingAccount.transfer(savingAccount, 300);
        long actual = savingAccount.getBalance();
        Assertions.assertEquals(1300, actual);
    }

    @Test
    public void shouldAdd() {
        checkingAccount.add(300);
        long actual = checkingAccount.getBalance();
        Assertions.assertEquals(1300, actual);
    }
}
