package part2.part2_1;

/**
 * Задание 2.1 — Менеджер (подкласс Employee)
 *
 * Формула бонуса: baseSalary * 0.15 + teamSize * 5000
 *
 * Подсказка для конструктора: вызовите super(name, baseSalary),
 * затем сохраните teamSize в поле.
 */
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double baseSalary, int teamSize) {
        super(name, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.15 + teamSize * 5000;
    }
}