package clients;

import accounts.Account;
import interfaces.MoneyTarget;

public class Client implements MoneyTarget {
    protected String name;
    protected int maxAccounts;
    protected Account[] accounts;

    public Client(String name, int maxAccounts) {
        this.name = name;
        this.maxAccounts = maxAccounts;
        this.accounts = new Account[maxAccounts];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxAccounts(int maxAccounts) {
        this.maxAccounts = maxAccounts;
    }

    public String getName() {
        return name;
    }

    public int getMaxAccounts() {
        return maxAccounts;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        // если дошли сюда, значит не нашлось свободной ячейки, иначе бы уже ушли из for
        System.out.println("Мест для добавления нового счёта нет! :(");
    }

    public boolean pay(int amount) {
        for (Account account : accounts) {
            if (account != null && account.pay(amount)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Имя клиента: " + name + ". Может иметь максимально: " + maxAccounts + " счетов, в настоящее время имеет " + accounts.length + " счета в банке";
    }

    @Override
    public boolean accept(int money) {
        for (Account account : accounts) {
            if (account != null && account.add(money)) {
                return true;
            }
        }
        return false;
    }
}
