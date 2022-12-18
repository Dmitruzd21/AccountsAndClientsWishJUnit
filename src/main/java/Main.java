import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import accounts.SavingAccount;
import clients.Client;

public class Main {
    public static void main(String[] args) {

        // Накопительный счет
        System.out.println("Создаем накопительный счет для Ивана с балансом 1000 и пополняем на 100");
        SavingAccount firstAccount = new SavingAccount(1000, "Ivan", 200);
        firstAccount.add(100);
        System.out.println(firstAccount.toString());
        System.out.println("Иван совершает покупку на 1000");
        System.out.println("Удалось ли совершить покупку: " + firstAccount.pay(1000));
        System.out.println(firstAccount.toString() + " КАК И ПРЕЖДЕ");
        System.out.println("Иван пытается совершить покупку на 50");
        System.out.println("Удалось ли совершить покупку: " + firstAccount.pay(50));
        System.out.println(firstAccount.toString());

        System.out.println();
        System.out.println("-------");
        System.out.println();

        // Кредитный счет
        System.out.println("Создаем кредитный счет для Олега с балансом 0 и пополняем на 100");
        CreditAccount secondAccount = new CreditAccount("Oleg");
        System.out.println("Получилось ли пополнить баланс более 0: " + secondAccount.add(100));
        System.out.println(secondAccount.toString());
        System.out.println("Огег покупает на 23 000");
        System.out.println("Удалось ли совершить покупку: " + secondAccount.pay(23_000));
        System.out.println(secondAccount.toString());

        System.out.println();
        System.out.println("-------");
        System.out.println();

        // Расчетный счет
        System.out.println("Создаем расчетный счет для Ксении с балансом 1000 и пополняем на 100");
        CheckingAccount thirdAccount = new CheckingAccount(1000, "Kseniya");
        thirdAccount.add(100);
        System.out.println(thirdAccount.toString());
        System.out.println("Ксения совершает покупку на 1101");
        System.out.println("Удалось ли совершить покупку: " + thirdAccount.pay(1101) + " - иначе баланс будет меньше нуля");
        System.out.println(thirdAccount.toString());
        System.out.println("Ксения пытается совершить покупку на 50");
        System.out.println("Удалось ли совершить покупку: " + thirdAccount.pay(50) + " -теперь получилось, баланс больше нуля");
        System.out.println(thirdAccount.toString());

        System.out.println();
        System.out.println("-------");
        System.out.println();

        // Создание клиента
        System.out.println("Создаем нового клиента Виктор...");
        Client richMan = new Client("Victor", 3);
        System.out.println("Создаем счета для нового клиента: один расчетный и два накопительных");
        CheckingAccount checkingAccount1 = new CheckingAccount(1000, richMan.getName());
        SavingAccount savingAccount1 = new SavingAccount(1000, richMan.getName(), 200);
        SavingAccount savingAccount2 = new SavingAccount(2000, richMan.getName(), 200);
        System.out.println("Теперь добавим счета клиенту...");
        richMan.add(checkingAccount1);
        richMan.add(savingAccount1);
        richMan.add(savingAccount2);
        System.out.println(richMan.toString());
        System.out.println("Виктор совершает покупку на сумму 500");
        System.out.println("Прошла ли транзакция? " + richMan.pay(500));
        System.out.println("Информация о счетах Виктора:");
        System.out.println();
        for (Account account : richMan.getAccounts()) {
            System.out.println(account.toString());
        }
        System.out.println();
        System.out.println("Попытаемся создать и добавить еще один счет");
        CheckingAccount checkingAccount2 = new CheckingAccount(999_000, richMan.getName());
        richMan.add(checkingAccount2);
        System.out.println("Жалко, а мы хотели подарить Виктору новый счет на 999 000 рублей(((");

        System.out.println();
        System.out.println("-------");
        System.out.println();

        // Проверка реалзации метода accept (на примере клиента - Виктора)
        System.out.println("Виктору необходимо зачислить 500 на любой из счетов - на первый, на который получиться");
        System.out.println("Предварительно посмотрим информацию о счетах виктора:");
        System.out.println();
        for (Account account : richMan.getAccounts()) {
            System.out.println(account.toString());
        }
        System.out.println();
        System.out.println("Теперь пытаемся зачислить 500 на любой из считов...");
        System.out.println("Удалось ли пополнить, какой либо счет? " + richMan.accept(500));
        System.out.println("Еще раз посмотрим на балансы счетов:");
        System.out.println();
        for (Account account : richMan.getAccounts()) {
            System.out.println(account.toString());
        }
    }
}
