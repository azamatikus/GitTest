package lesson5_2;

import java.util.Arrays;

public class Concurrency {

    static final int SIZE = 10_000_000;

    public static void main(String[] args) {

        method1();

        method2();

    }

    public static void method1() {

        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1); // 2

        long timeStart = System.currentTimeMillis();

        System.out.println("Start");

        for (int i = 0; i < SIZE; i++) {          // 4

            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Вычисление method1 заняло " + (System.currentTimeMillis() - timeStart) + " времени");

    }


        public static void method2() {

        System.out.println("method2 begin");

        final int h = SIZE / 2;
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1); // 2

        long before = System.currentTimeMillis();   // 3

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {

                    a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }));
        t1.start();

        Thread t2 = new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {

                    a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }));

        t2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Вычисление method2 заняло " + (System.currentTimeMillis() - before) + " времени");

        System.out.println("method2 end");

    }

    }
