package accounts;

public class SavingAccount extends Account {
    private long minBalance;

    public SavingAccount(long balance, String ownerName, long minBalance) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.minBalance = minBalance;
    }

    public void setMinBalance(long minBalance) {
        this.minBalance = minBalance;
    }

    public long getMinBalance() {
        return minBalance;
    }

    @Override
    public boolean pay(long amount) {
        long newBalance = balance - amount;
        if (newBalance > minBalance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        accountTo.balance += amount;
        balance -= amount;
        return true;
    }

    @Override
    public boolean accept(int money) {
        balance += money;  // также можно вызвать метод add
        return true;
    }

    @Override
    public String toString() {
        return "У владельца " + ownerName + " текущий баланс накопительного счета: " + balance;
    }

}
