package part2.part2_1;

/**
 * Задание 2.1 — Разработчик (подкласс Employee)
 *
 * Формула бонуса: baseSalary * 0.12
 *
 * Подсказка для конструктора: вызовите super(name, baseSalary),
 * затем сохраните language.
 */

class Developer extends Employee {
    private String language;

    public Developer(String name, double baseSalary, String language) {
        super(name, baseSalary);
        this.language = language;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.12;
    }
}