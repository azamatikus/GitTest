package lesson1.animal;

import lesson1.Participant;
import lesson1.enums.Color;

/**
 * Робот не является животным, но может учавствовать в соревнованиях
 * так как реализует интерфейс {@link Participant}
 */
public class Robot extends Animal implements Participant {

    private boolean isOnDistance;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, Color color, int age, int runDistance, int jumpHeight) {
        super(name, color, age);
        this.isOnDistance = true;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void voice() {
        System.out.println(".№,№:;(!№%,;%№%%№,№;%%%№№_)()()№!");
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
            System.out.println(String.format("Робот %s не смог преодолеть дистанцию и выбывает", getName(), distance));
            return;
        }
        System.out.println(String.format("Робот %s пробежал кросс длинной %d", getName(), distance));
    }

    @Override
    public void jump(int height) {
        if (!isOnDistance) {
            return;
        }
        if (height > jumpHeight) {
            isOnDistance = false;
            System.out.println(String.format("Робот %s не смог преодолеть высоту и выбывает", getName(), height));
            return;
        }
        System.out.println(String.format("Робот %s прыгнул на высоту %d", getName(), height));
    }

    @Override
    public void swim(int distance) {
        isOnDistance = false;
        System.out.println("Робот не умеет плавать и выбывает сразу");
        // throw new UnsupportedOperationException("Кошка не умеет плавать");
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }
}
