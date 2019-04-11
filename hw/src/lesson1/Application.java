package lesson1;

import lesson1.animal.Cat;
import lesson1.animal.Dog;
import lesson1.animal.Human;
import lesson1.animal.Robot;
import lesson1.course.Course;
import lesson1.course.Cross;
import lesson1.course.Wall;
import lesson1.course.Water;
import lesson1.enums.Color;

/**
 * Класс для запуска приложения - симулятор кросса
 */
public class Application {

    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Мурзик", Color.BLACK, 1, 100, 5),
                new Dog("Шарик", Color.BLACK, 1, 80, 7, 100),
                new Robot("SP-061", Color.BLACK, 1082, 80000, 4),
                new Human("простак Вася", Color.BLACK, 22, 8000, 1, 200)
                // здесь должны быть участники всех видов (Cat, Dog, Human, Robot)
        );

        Course course = new Course(
                new Cross(50),
                new Wall(1),
                new Water(50)
        );

        course.doIt(team);
    }
}
