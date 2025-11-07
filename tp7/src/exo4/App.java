package exo4;

import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Compteur compteur = new Compteur();
        try{
            FileWriter writer = new FileWriter("resultat_sans_sync.csv");
            Thread[] threads = new Thread[5];
            for (int i = 0; i < 5; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        compteur.incrementer(writer);
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

            System.out.println("Valeur finale: " + compteur.value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
