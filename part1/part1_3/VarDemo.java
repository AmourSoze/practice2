package part1.part1_3;

import java.util.ArrayList;
import java.util.Arrays;

public class VarDemo {

    // класс для 5-го примера
    static class BankAccount {
    }

    public static void main(String[] args) {

        // 5 примеров Var

        // 1. int (примитивный тип)
        var number = 42;
        System.out.println(number + " - " + ((Object) number).getClass().getSimpleName());

        // 2. String
        var text = "Java";
        System.out.println(text + " - " + text.getClass().getSimpleName());

        // 3. ArrayList
        var list = new ArrayList<String>();
        list.add("один");
        list.add("два");
        System.out.println(list + " - " + list.getClass().getSimpleName());

        // 4. Массив
        var array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array) + " - " + array.getClass().getSimpleName());

        // 5. Собственный объект
        var account = new BankAccount();
        System.out.println("BankAccount - " + account.getClass().getSimpleName());


        // Примеры где var не компилируются

        // 1. var без инициализации:
        // var x;
        // x = 10;
        // ошибка - variable x might not have been initialized.
        // почему - Компилятор не может вывести тип переменной, если она не инициализирована в момент объявления.

        // 2. var как параметр метода:
        // public void myMethod(var param) { }
        // ошибка - 'var' is not allowed as a parameter type.
        // почему - var разрешён только для локальных переменных внутри методов; в сигнатуре обычных методов указание типа обязательно.

        // 3. var как поле класса:
        // public class Example { var field = 10; }
        // ошибка - 'var' is not allowed for fields.
        // почему - var можно использовать только для локальных переменных внутри методов или блоков инициализации, но не для полей класса.

        // 4. var с null:
        // var x = null;
        // ошибка - Cannot infer type: 'var' cannot be initialized with 'null'.
        // почему - Компилятор не может определить конкретный тип, так как null совместим с любым ссылочным типом.

    }
}