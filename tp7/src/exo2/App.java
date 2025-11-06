package exo2;

public class App {
    public static void main(String[] args) throws InterruptedException {

        
        Thread t1 = new Thread(new Tache(), "Thread-1");
        Thread t2 = new Thread(new Tache(), "Thread-2");
        Thread t3 = new Thread(new Tache(), "Thread-3");

        
        t1.start();
        t2.start();
        t3.start();

    }
}


class Tache implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "||" + (i ));
        }
    }
}
