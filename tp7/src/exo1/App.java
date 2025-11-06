package exo1;
public class App {
    private static final Object lock = new Object();
    private static boolean turnOfTask1 = true;
    public static void main(String[] args) throws Exception {
        Thread T1 = new Thread(() -> {
            for (int i = 0; i <= 20; i += 2) {
                synchronized (lock) {
                    while (!turnOfTask1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Task 1 valeur : " + i);
                    turnOfTask1 = false;
                    lock.notifyAll();
                }
            }
        });

        Thread T2 = new Thread(() -> {
            for (int i = 1; i <= 20; i += 2) {
                synchronized (lock) {
                    while (turnOfTask1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Task 2 valeur : " + i);
                    turnOfTask1 = true;
                    lock.notifyAll();
                }
            }
        });

        T1.start();
        T2.start();
    }
}

