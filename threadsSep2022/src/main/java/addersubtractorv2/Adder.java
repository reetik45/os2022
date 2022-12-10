package addersubtractorv2;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count count;

    private Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    // incrementValue is handling concurrency and multithreading internally
    @Override
    public void run() {
        for(int i = 1; i <= 10000; ++i) {
//            lock.lock();
            count.incrementValue(i);
//            lock.unlock();
        }
    }
}
