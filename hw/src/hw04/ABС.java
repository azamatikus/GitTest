package hw04;

public class ABС {

//    private final Object mon = new Object();
    private static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(ABС::printA).start();
        new Thread(ABС::printB).start();
        new Thread(ABС::printC).start();
    }

    private synchronized static void printA() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'A') {
                    ABС.class.wait();
                }
                Thread.sleep(30);
                System.out.print("A");
                currentLetter = 'B';
                ABС.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printB() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'B') {
                    ABС.class.wait();
                }
                Thread.sleep(70);
                System.out.print("B");
                currentLetter = 'C';
                ABС.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printC() {
        for (int i = 0; i < 5; i++) {
            try {
                while (currentLetter != 'C') {
                    ABС.class.wait();
                }
                Thread.sleep(50);
                System.out.print("C");
                currentLetter = 'A';
                ABС.class.notifyAll();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
