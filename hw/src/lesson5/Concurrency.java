package lesson5;

public class Concurrency {

    private final Object lock1 = new Object();

    public static void main(String[] args) {
        Concurrency e2 = new Concurrency();
        System.out.println("Start");

        new Thread(() -> e2.method1()).start();
        new Thread(() -> e2.method2()).start();
    }

    private void method1() {

        System.out.println("method1 begin");

        final int size = 10000000;
        float[] arr = new float[size];            // 1

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;                           // 2
        }

        long before = System.currentTimeMillis(); // 3

        for (int i = 0; i < size; i++) {          // 4

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long after = System.currentTimeMillis();  // 5

        long diff = after - before;

        System.out.println(diff);                 // 6
        System.out.println("method1 end");

    }

//    _______________________________________________________________

    public void method2() {

        System.out.println("method2 begin");

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];              // 1
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;                             // 2
        }

        long before = System.currentTimeMillis();   // 3


        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        synchronized (lock1) {
            for (int i = 0; i < a1.length; i++) { // 4_1

                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        synchronized (lock1) {
            for (int i = 0; i < a2.length; i++) { // 4_2

                a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long after = System.currentTimeMillis();   // 5

        long diff = after - before;

        System.out.println(diff);                  // 6

        System.out.println("method2 end");

    }
}
