package addersubtractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {
    private Count count;

    private Lock lock;
    private Lock lock2 = new ReentrantLock();

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 100000; ++i) {
                lock2.lock();
                count.value += i;
                lock2.unlock();
        }
    }
}
