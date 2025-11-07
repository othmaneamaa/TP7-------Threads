package exo4;

import java.io.FileWriter;
import java.io.IOException;

public class Compteur {
        public int value = 0;
        public synchronized void incrementer(FileWriter writer) {
        value ++;
    try {
        writer.write(Thread.currentThread().getName() + " ; " + value + "\n");
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
