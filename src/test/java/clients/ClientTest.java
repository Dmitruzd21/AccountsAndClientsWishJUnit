package clients;

import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    Client richMan;
    CheckingAccount checkingAccount;
    SavingAccount savingAccount;

    @BeforeEach
    public void clientAndAccountsCreation() {
        richMan = new Client("Victor", 3);
        checkingAccount = new CheckingAccount(1000, richMan.getName());
        savingAccount = new SavingAccount(1000, richMan.getName(), 200);
        richMan.add(checkingAccount);
        richMan.add(savingAccount);
    }

    @Test
    public void shouldAddTwoAccountsIfLimitIsThree() {
        Account[] expected = {checkingAccount, savingAccount, null};
        Account[] actual = richMan.getAccounts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddFourAccountsIfLimitIsThree() {
        CreditAccount creditAccount1 = new CreditAccount(richMan.getName());
        CreditAccount creditAccount2 = new CreditAccount(richMan.getName());
        richMan.add(creditAccount1);
        richMan.add(creditAccount2);
        Account[] expected = {checkingAccount, savingAccount, creditAccount1};
        Account[] actual = richMan.getAccounts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldPay() {
        richMan.pay(200);
        long actual = checkingAccount.getBalance();
        Assertions.assertEquals(800, actual);
    }

    @Test
    public void shouldAccept() {
        richMan.accept(300);
        long actual = checkingAccount.getBalance();
        Assertions.assertEquals(1300, actual);
    }
}