package producerconsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private int maxSize;

    private Semaphore ps;
    private Semaphore cs;
    private String name;

    public Producer(Queue<Object> queue, int maxSize, Semaphore ps, Semaphore cs, String name){
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
                ps.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (queue.size() < maxSize) {
                System.out.println(this.name + " trying to add " + "queue size - " + queue.size());
                queue.add(new Object());
            }
            cs.release();
        }
    }
}
