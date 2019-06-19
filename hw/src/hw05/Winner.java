package hw05;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static hw05.MainClass.CARS_COUNT;

public class Winner extends Stage {

    //private Lock lock = new ReentrantLock();
    private CountDownLatch latch = new CountDownLatch(CARS_COUNT);

    @Override
    public void go(Car c)
    {
        latch.countDown();

//      lock.lock();
        if (latch.getCount() == CARS_COUNT - 1) {
            System.out.println(c.getName() + " - WIN");
        }

        if (latch.getCount() == 0) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}