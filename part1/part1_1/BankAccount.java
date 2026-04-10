package part1.part1_1;

/**
 * Задание 1.1 — Банковский счёт
 *
 * Тема: статические и экземплярные блоки инициализации, инкапсуляция.
 *
 * Ключевая теория:
 *   - static { ... } выполняется ОДИН РАЗ при загрузке класса (после статических полей, до new).
 *   - { ... } (блок экземпляра) выполняется при каждом new, после явной инициализации полей в объявлении, ДО тела конструктора.
 *   - Порядок при new: блок экземпляра → конструктор (статическая часть класса уже выполнена один раз).
 *   - static-поле принадлежит классу, а не объекту (общее для всех экземпляров).
 *   - Для форматирования double: String.format("%.2f", value)
 *
 * Как запустить: нажмите ▶ рядом с main.
 *
 * Ожидаемый вывод:
 *   Банковская система инициализирована
 *   Создание счёта #1
 *   Создание счёта #2
 *   [ACC-1] Алиса: 1000.00 руб.
 *   [ACC-2] Борис: 500.00 руб.
 *   После пополнения: [ACC-1] Алиса: 1500.00 руб.
 *   После снятия: [ACC-1] Алиса: 1300.00 руб.
 *   Ошибка: недостаточно средств
 *   Ошибка: сумма должна быть положительной
 *   Всего счетов: 2
 */
public class BankAccount {

    private String owner;
    private double balance;
    private String accountNumber;

    private static int totalAccounts;
    private static String bankName;

    static {
        bankName = "Java Bank";
        System.out.println("Банковская система инициализирована");
    }

    {
        totalAccounts++;
        System.out.println("Создание счёта #" + totalAccounts);
    }

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        this.accountNumber = "ACC-" + totalAccounts;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть положительной");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств");
        } else {
            balance -= amount;
        }
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f руб.", accountNumber, owner, balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Алиса", 1000);
        BankAccount a2 = new BankAccount("Борис", 500);

        System.out.println(a1);
        System.out.println(a2);

        a1.deposit(500);
        System.out.println("После пополнения: " + a1);

        a1.withdraw(200);
        System.out.println("После снятия: " + a1);

        a1.withdraw(5000);

        a2.deposit(-100);

        System.out.println("Всего счетов: " + BankAccount.getTotalAccounts());
    }
}