package addersubtractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Subtractor implements Runnable {
    private Count count;

    private Lock lock;
    private Lock lock2 = new ReentrantLock();

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1 ; i <= 100000; ++i) {
//            lock.lock();
//            synchronized (count){
            lock2.lock();
                count.value -= i;
//            }
            lock2.unlock();
//            lock.unlock();
        }
    }
}
