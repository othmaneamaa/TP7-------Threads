package exo4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CompteurAvecLock {
        public int value = 0;
        private final Lock lock = new ReentrantLock();
        public void incrementer(FileWriter writer) {
        value ++;
        lock.lock();
    try {
        writer.write(Thread.currentThread().getName() + " ; " + value + "\n");
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        }
    }
}


