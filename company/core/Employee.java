package company.core;

/**
 * Задание 1.2 — Модификаторы доступа (исходный класс)
 *
 * ВНИМАНИЕ: этот файл содержит НАМЕРЕННЫЕ проблемы видимости.
 * НЕ ИЗМЕНЯЙТЕ его. Проанализируйте, какие строки в HRSystem.java
 * вызовут ошибку компиляции, и заполните таблицу в answers/task1_2_access_table.md.
 *
 * Теория — модификаторы доступа:
 *   - public    → доступен отовсюду
 *   - protected → тот же пакет + наследники (даже из другого пакета)
 *   - (без модификатора, package-private) → только в том же пакете
 *   - private   → только внутри своего класса
 *
 * Employee в пакете company.core, HRSystem в company.app.
 * HRSystem НЕ наследует Employee.
 */
public class Employee {
    public String name;
    protected int age;
    double salary;              // package-private
    private String password;

    public Employee(String name, int age, double salary, String password) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password = password;
    }

    public String getRole() {
        return "Employee";
    }

    protected void promote(double raise) {
        this.salary += raise;
    }

    void printSummary() {
        System.out.println(name + ", " + age + " лет, " + salary + " руб.");
    }

    private boolean validatePassword(String input) {
        return password.equals(input);
    }
}