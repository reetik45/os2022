package producerconsumer2;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    private Semaphore ps;
    private Semaphore cs;

    public Producer(Queue<Object> queue, int maxSize, Semaphore ps, Semaphore cs){
        this.queue = queue;
        this.maxSize = maxSize;
        this.ps = ps;
        this.cs = cs;
    }
    @Override
    public void run() {
        while(true){
            try {
                ps.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.add(new Object());
            cs.release();
//            cs.release();
        }
    }
}
