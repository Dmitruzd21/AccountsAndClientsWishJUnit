package accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(long balance, String ownerName) {
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // проверка, чтобы баланс при оплате не стал меньше 0
    @Override
    public boolean pay(long amount) {
        long newBalance = balance - amount;
        if (newBalance > 0) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        if (pay(amount)) {
            if (accountTo.add(amount)) {
                return true;
            } else {
                pay(amount);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean accept(int money) {
        balance += money;  // также можно вызвать метод add
        return true;
    }

    @Override
    public String toString() {
        return "У владельца " + ownerName + " текущий баланс расчетного счета: " + balance;
    }

}
