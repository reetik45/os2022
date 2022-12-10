package addersubtractor;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        // Address of count = abc465;

        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();


        // join is waiting for the t1/t2 thread to finish
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
