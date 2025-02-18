// Explanation: Two threads, t1 and t2, 
// increment the shared counter variable concurrently. 
// The inc() and get() methods are synchronized, meaning only one thread can execute these methods 
// at a time, preventing race conditions. The program ensures that the final value of the counter 
// is consistent and correctly updated by both threads.

public class thread_synchronization {
    public static void main(String[] args) {
        Counter count = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.increament();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.increament();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count.decrement();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value
        System.out.println("Counter: " + count.get());
    }
}

class Counter {
    private int counter = 0;

    public synchronized void increament() {
        counter++;
    }

    public synchronized int get() {
        return counter;
    }

    public void decrement() {
        // synchronized block
        synchronized (this) {
            counter--;
        }
    }
}