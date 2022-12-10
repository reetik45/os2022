package producerconsumer2;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> objects = new ConcurrentLinkedDeque<>();

        Semaphore ps = new Semaphore(6);
        Semaphore cs = new Semaphore(0);

        Producer p1 = new Producer(objects, 6, ps, cs);
        Producer p2 = new Producer(objects, 6, ps, cs);
        Producer p3 = new Producer(objects, 6, ps, cs);
        Producer p4 = new Producer(objects, 6, ps, cs);
        Producer p5 = new Producer(objects, 6, ps, cs);

        Consumer c1 = new Consumer(objects, 6, ps, cs);
        Consumer c2 = new Consumer(objects, 6, ps, cs);
        Consumer c3 = new Consumer(objects, 6, ps, cs);
        Consumer c4 = new Consumer(objects, 6, ps, cs);
        Consumer c5 = new Consumer(objects, 6, ps, cs);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
        Thread t4 = new Thread(p4);
        t4.start();
        Thread t5 = new Thread(p5);
        t5.start();

        Thread t6 = new Thread(c1);
        t6.start();
        Thread t7 = new Thread(c2);
        t7.start();
        Thread t8 = new Thread(c3);
        t8.start();
        Thread t9 = new Thread(c4);
        t9.start();
        Thread t10 = new Thread(c5);
        t10.start();


    }
}
