package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    private Semaphore ps;
    private Semaphore cs;

    private String name;

    public Consumer(Queue<Object> queue, int maxSize, Semaphore ps, Semaphore cs, String name){
        this.queue = queue;
        this.maxSize = maxSize;
        this.ps = ps;
        this.cs = cs;
        this.name = name;
    }
    @Override
    public void run() {
        while(true){
            try {
                cs.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (queue.size() > 0) {
                System.out.println(this.name + " trying to remove " + "queue size - " + queue.size());
                queue.remove();
            }
            ps.release();
        }
    }
}
