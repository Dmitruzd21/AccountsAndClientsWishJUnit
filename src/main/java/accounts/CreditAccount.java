package accounts;

public class CreditAccount extends Account {
    public CreditAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    // проверка, что пополнение не создаст положительный баланс (по условию балан только отрицательный)
    @Override
    public boolean add(long amount) {
        long newBalance = balance + amount;
        if (newBalance < 0) {
            long oldBalance = balance;
            balance += amount;
            if (balance > oldBalance) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean transfer(Account accountTo, long amount) {
        long newBalance = balance + amount;
        if (newBalance < 0) {
            accountTo.balance += amount;
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean accept(int money) {
        long newBalance = balance + money;  // также можно вызвать метод add
        if (newBalance < 0) {
            balance += money;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "У владельца " + ownerName + " текущий баланс кредитного счета: " + balance;
    }

}
