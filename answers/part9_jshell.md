# Часть 9 — Эксперименты в jshell

## Как запустить jshell

Откройте терминал IntelliJ (View → Tool Windows → Terminal) и введите:
```
jshell
```
Для выхода: `/exit`

---

## Задание 9.1: Sealed-классы

### Команды (скопируйте и вставьте в jshell)

```
sealed interface Shape permits Circle, Square {}
record Circle(double r) implements Shape {}
record Square(double side) implements Shape {}
Shape s = new Circle(5)
s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
```

### Фактический вывод:


```
jshell> sealed interface Shape permits Circle, Square {}
|  created interface Shape, however, it cannot be referenced until class Circle, and class Square are declared

jshell> record Circle(double r) implements Shape {}
|  created record Circle, however, it cannot be referenced until class Shape is declared

jshell> record Square(double side) implements Shape {}
|  created record Square

jshell> Shape s = new Circle(5)
s ==> Circle[r=5.0]
```

### Вопрос: Что произойдёт при попытке создать `record Triangle(double a) implements Shape {}`?

**Compilation Error**



---

## Задание 9.2: Цепочка лямбд

### Команды

```
import java.util.function.*
Function<String, String> trim = String::trim
Function<String, String> upper = String::toUpperCase
Function<String, String> exclaim = s -> s + "!"
var pipeline1 = trim.andThen(upper).andThen(exclaim)
var pipeline2 = exclaim.compose(upper).compose(trim)
pipeline1.apply("  hello world  ")
pipeline2.apply("  hello world  ")
```

### Фактический вывод:

```
| imported package java.util.function
trim ==> $Lambda$... (reference to String::trim)
upper ==> $Lambda$... (reference to String::toUpperCase)
exclaim ==> $Lambda$...
pipeline1 ==> $Lambda$...
pipeline2 ==> $Lambda$...
$9 ==> "HELLO WORLD!"
$10 ==> "HELLO WORLD!"
```

### Вопрос: Дают ли `andThen()` и `compose()` одинаковый результат? В каком случае результаты будут различаться?

**Да. Когда приоритет операций будет иметь значение**



---

## Задание 9.3: Сравнение EnumSet и HashSet

### Команды

```
enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK }
var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
var hashSet = new java.util.HashSet<>(java.util.Set.of(Color.RED, Color.GREEN, Color.BLUE))
enumSet.contains(Color.RED)
hashSet.contains(Color.RED)
enumSet.getClass().getSimpleName()
hashSet.getClass().getSimpleName()
```

### Фактический вывод:

```
| created enum Color
enumSet ==> [RED, GREEN, BLUE]
hashSet ==> [RED, GREEN, BLUE]
$5 ==> true
$6 ==> true
$7 ==> "RegularEnumSet"
$8 ==> "HashSet"
```

### Вопрос: Почему внутренний класс EnumSet называется `RegularEnumSet`? Что произойдёт, если enum будет иметь больше 64 констант?

**Поскольку enum < 64. При enum > 64 создается JumboEnumSet на long[]**

