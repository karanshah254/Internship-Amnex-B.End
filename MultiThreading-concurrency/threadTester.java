public class threadTester {
    public static void main(String[] args) {
        System.out.println("main has started");
        // Thread thread1 = new Thread1("thread1");
        // thread1.start();

        // Thread thread2 = new Thread(new Thread2(), "thread2");
        // use of lambda expression
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + ", " + i);
            }
        }, "thread2");
        thread2.start();
        System.out.println("main has ended");

        // order of running is not fixed
    }
}

// extending thread class
class Thread1 extends Thread {
    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("inside " + Thread.currentThread() + " " + i);
        }
    }
}

// implementing runnable interface
class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + ", " + i);
        }
    }
    
}