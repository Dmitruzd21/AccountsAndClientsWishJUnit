package accounts;

import interfaces.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String ownerName;

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public abstract boolean pay(long amount);

    public abstract boolean add(long amount);

    public abstract boolean transfer(Account accountTo, long amount);
}
