package exo3;

public class App {


    public static boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {


        Thread T1 = new Thread(() -> {

            for (int i = 1; i < 250; i++) {
                if (estPremier(i)) System.out.println("T1 : " + i);
            }
        });

        Thread T2 = new Thread(() -> {

            for (int i = 250; i < 500; i++) {
                if (estPremier(i)) System.out.println("T2 : " + i);
            }
        });

        Thread T3 = new Thread(() -> {

            for (int i = 500; i < 750; i++) {
                if (estPremier(i)) System.out.println("T3 : " + i);
            }
        });

        Thread T4 = new Thread(() -> {

            for (int i = 750; i < 1000; i++) {
                if (estPremier(i)) System.out.println("T4 : " + i);
            }
        });


        T1.start();
        T2.start();
        T3.start();
        T4.start();


        try {
            T1.join();
            T2.join();
            T3.join();
            T4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
