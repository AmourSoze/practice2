package part2.part2_1;

/**
 * Задание 2.1 — Стажёр (подкласс Employee)
 *
 * Формула бонуса: фиксированные 10000 рублей.
 *
 * Подсказка для конструктора: вызовите super(name, baseSalary).
 * Дополнительных полей нет.
 */
class Intern extends Employee {

    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return 10000;
    }
}