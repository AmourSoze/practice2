package company.core;

/**
 * Задание 1.2 — Исправленный Employee с правильной инкапсуляцией
 *
 * Тема: инкапсуляция — один из четырёх принципов ООП.
 *
 * Ключевая теория:
 *   - Инкапсуляция = скрытие внутреннего состояния от внешнего кода.
 *   - Все поля — private.
 *   - Доступ через геттеры (чтение) и сеттеры (изменение).
 *   - Приватные методы скрывают детали; публичный метод-«фасад» вызывает их.
 *
 * Задача:
 *   1. Все поля — private (уже сделано)
 *   2. Геттеры для name, age, salary (но НЕ для password)
 *   3. promote() — public
 *   4. printSummary() — public
 *   5. validatePassword() остаётся private;
 *      добавьте public authenticate(input), который вызывает validatePassword().
 */
public class EmployeeFixed {

    private String name;
    private int age;
    private double salary;
    private String password;

    public EmployeeFixed(String name, int age, double salary, String password) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }


    public void promote(double raise) {
        if (raise > 0) {
            this.salary += raise;
        }
    }

    public void printSummary() {
        System.out.println(name + ", " + age + " лет, " + salary + " руб.");
    }

    private boolean validatePassword(String input) {
        return password != null && password.equals(input);
    }

    public boolean authenticate(String input) {
        return validatePassword(input);
    }

    public String getRole() {
        return "Employee";
    }
}