package exo4;

import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        CompteurAvecLock compteurAL = new CompteurAvecLock();
        try{
            FileWriter writer = new FileWriter("resultat_sans_sync1.csv");
            Thread[] threads = new Thread[5];
            for (int i = 0; i < 5; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        compteurAL.incrementer(writer);
                    }
                }, "Thread -" + i);
                threads[i].start();
            }


            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Valeur finale: " + compteurAL.value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
