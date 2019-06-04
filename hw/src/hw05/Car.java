package hw05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable
{
    static { CARS_COUNT = 0;}
    private static int    CARS_COUNT;
    private CyclicBarrier cb;
    private Race          race ;
    private int           speed;
    private String        name ;
    //private volatile int i = 0;

    public Car(Race race,
               int speed,
               CyclicBarrier cb)
    {
        CARS_COUNT++;
        this.race  = race;
        this.speed = speed;
        this.name  = "Участник #" + CARS_COUNT;
        this.cb    = cb;
    }

    @Override
    public void run()
    {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            cb.await();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            try {
                race.getStages().get(i).go(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


//        ++i;
//        if (i == 1){
//            System.out.println(name + " - WIN");
//
//        }

    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

}
