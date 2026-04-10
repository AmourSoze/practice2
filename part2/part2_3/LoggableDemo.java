package part2.part2_3;

/**
 * Задание 2.3 — Демонстрация интерфейса Loggable (точка входа)
 *
 * Как запустить: нажмите ▶ рядом с main.
 *
 * Ожидаемый вывод (время будет отличаться):
 *
 * Уровень логирования: INFO
 *
 * [14:30:15] [DatabaseService] Подключение к jdbc:postgresql://localhost/mydb
 * [14:30:15] [DatabaseService] Подключение установлено
 *
 * [14:30:15] [AuthService] Вход пользователя: admin — успешно
 * [14:30:15] [AuthService] ОШИБКА: Вход пользователя: hacker — отказано
 */
public class LoggableDemo {
    public static void main(String[] args) {
        DatabaseService db = new DatabaseService();
        AuthService auth = new AuthService();

        System.out.println("Уровень логирования: " + Loggable.getLogLevel());
        System.out.println();

        db.connect("jdbc:postgresql://localhost/mydb");
        System.out.println();

        auth.login("admin", true);
        auth.login("hacker", false);
    }
}