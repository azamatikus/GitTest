package hw05;

import java.util.concurrent.CyclicBarrier;

public class MainClass
{

    static final int CARS_COUNT = 4;

    private static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args)
    {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60),
                             new Tunnel(),
                             new Road(40),
                             new Winner());

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
            new Thread(cars[i]).start();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

    }
}
