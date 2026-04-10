package part2.part2_1;

/**
 * Задание 2.1 — Иерархия сотрудников (абстрактный класс)
 *
 * Тема: абстрактные классы и полиморфизм.
 *
 * Ключевая теория:
 *   - Абстрактный класс — класс с модификатором abstract. Нельзя создать
 *     его экземпляр напрямую (new Employee() — ошибка компиляции).
 *   - Абстрактный метод — метод без тела. Каждый подкласс обязан его реализовать.
 *   - Обычные (не абстрактные) методы абстрактного класса наследуются как есть.
 *   - Паттерн «шаблонный метод»: totalCompensation() вызывает
 *     calculateBonus(), но реализация бонуса зависит от подкласса.
 *
 * Примечание: запускать нужно EmployeeBonus.java, а не этот файл.
 */
abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateBonus();

    public double totalCompensation() {
        return baseSalary + calculateBonus();
    }

    @Override
    public String toString() {
        double bonus = calculateBonus();
        double total = totalCompensation();
        return String.format("%s | Оклад: %.1f | Бонус: %.1f | Итого: %.1f",
                name, baseSalary, bonus, total);
    }
}