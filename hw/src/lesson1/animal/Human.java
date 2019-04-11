package lesson1.animal;

import lesson1.Participant;
import lesson1.enums.Color;

public class Human extends Animal implements Participant {

private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;
    private int swimDistance;

    public Human (String name, Color color, int age, int runDistance, int jumpHeight, int swimDistance) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
        this.swimDistance = swimDistance;
    }


    @Override
    public void voice() {

        System.out.println("Бонжур, ребятушки");
    }

    @Override
    public boolean isOnDistance() {

        return isOnDistance;

//         доработать по аналогии с классом Cat
    }

    @Override
    public void run(int distance) {

        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не смогл пробежать дистанцию и выбывает", getName(), distance));
            return;
        }
        System.out.println(String.format("Человек %s пробежал кросс длинной %d", getName(), distance));

        // доработать по аналогии с классом Cat
    }

    @Override
    public void jump(int height) {

        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не смог преодолеть высоту и выбывает", getName(), height));
            return;
        }
        System.out.println(String.format("Человек %s пругнул на высоту %d", getName(), height));

        // доработать по аналогии с классом Cat
    }

    @Override
    public void swim(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance> swimDistance) {
            isOnDistance = false;
            System.out.println(String.format("Человек %s не смогл проплыть и выбывает проигравшим посмертно", getName(), distance));
            return;
        }
        System.out.println(String.format("Человек %s проплыл %d", getName(), distance));

        // доработать по аналогии с классом Cat
    }
}
