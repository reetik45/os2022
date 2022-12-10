package producerconsumer;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> objects = new ConcurrentLinkedDeque<>();

        Semaphore ps = new Semaphore(6);
        Semaphore cs = new Semaphore(0);

        Producer p1 = new Producer(objects, 6, ps, cs, "p1");
        Producer p2 = new Producer(objects, 6, ps, cs, "p2");
        Producer p3 = new Producer(objects, 6, ps, cs, "p3");
        Producer p4 = new Producer(objects, 6, ps, cs, "p4");
        Producer p5 = new Producer(objects, 6, ps, cs, "p5");
        Producer p6 = new Producer(objects, 6, ps, cs, "p6");

        Consumer c1 = new Consumer(objects, 6, ps, cs, "c1");
        Consumer c2 = new Consumer(objects, 6, ps, cs, "c2");
        Consumer c3 = new Consumer(objects, 6, ps, cs, "c3");
        Consumer c4 = new Consumer(objects, 6, ps, cs, "c4");
        Consumer c5 = new Consumer(objects, 6, ps, cs, "c5");
        Consumer c6 = new Consumer(objects, 6, ps, cs, "c6");

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
        Thread t6 = new Thread(p6);
        t6.start();


        Thread t7 = new Thread(c1);
        t7.start();
        Thread t8 = new Thread(c2);
        t8.start();
        Thread t9 = new Thread(c3);
        t9.start();
        Thread t10 = new Thread(c4);
        t10.start();
        Thread t11 = new Thread(c5);
        t11.start();
        Thread t12 = new Thread(c6);
        t12.start();


    }
}
