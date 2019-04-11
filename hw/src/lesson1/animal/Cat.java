package lesson1.animal;

import lesson1.Participant;
import lesson1.enums.Color;

public class Cat extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void voice() {
        System.out.println("Мяу, епта");
    }

    @Override
    public boolean isOnDistance() {

        return isOnDistance;
    }

    @Override
    public void run(int distance) {
        if (!isOnDistance) {
            return;
        }
        if (distance > runDistance) {
            isOnDistance = false;
            System.out.println(String.format("Кошка %s не смогла преодолеть дистанцию и выбывает", getName(), distance));
            return;
        }
        System.out.println(String.format("Кошка %s пробежала кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Кошка %s не смогла преодолеть высоту и выбывает", getName(), height));
            return;
        }
        System.out.println(String.format("Кошка %s прыгнула на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Кошка не умеет плавать и выбывает сразу");
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
