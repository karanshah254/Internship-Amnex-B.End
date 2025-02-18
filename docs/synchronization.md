## What is synchronzation ?
- >It is concept of multi-threading.
- >Synchronization is crucial for ensuring that multiple threads operate safely on shared resources. Without Synchronization, data inconsistency or corruption can occur when multiple threads try to access and modify shared variables simultaneously.
- >in java, it is mechanism that ensures that only on thread can access the shared resource at any given time.
- >This process helps prevent issues such as data inconsistency and race conditions when multiple threads interact with shared resources.

## How it is used in java programming ?
- >It is used in two ways
    1. Using synchronized block
    2. Declaring method synchronized
- >Example:
```java
// decalring method synchronized
class Counter {
    private int c = 0; // Shared variable

    // Synchronized method to increment counter
    public synchronized void inc() {
        c++;
    }

    // Synchronized method to get counter value
    public synchronized int get() {
        return c;
    }
}
public class SynchronizedTest {
    public static void main(String[] args) {
        Counter cnt = new Counter(); // Shared resource

        // Thread 1 to increment counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cnt.inc();
            }
        });

        // Thread 2 to increment counter
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cnt.inc();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value
        System.out.println("Counter: " + cnt.get());
    }
}
```
- >Explanation: Two threads, t1 and t2, increment the shared counter variable concurrently. The inc() and get() methods are synchronized, meaning only one thread can execute these methods at a time, preventing race conditions. The program ensures that the final value of the counter is consistent and correctly updated by both threads.

## Using synchronized blocks
- >A synchronized block in Java is synchronized on some object. Synchronized blocks in Java are marked with the synchronized keyword. All synchronized blocks synchronize on the same object and can only have one thread executed inside them at a time. All other threads attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.
- >Example:
```java
synchronize(sync_object) {
    // access of shared variable and other resources
}
```
- >This synchronization is implemented in Java with a concept called **monitors or locks**. Only one thread can own a monitor at a given time. When a thread acquires a lock, it is said to have entered the monitor. All other threads attempting to enter the locked monitor will be suspended until the first thread exits the monitor.
- >Sample code:
```java
class Counter {
    private int c = 0; // Shared variable

    // Method with synchronization block
    public void inc() {
        synchronized(this) { // Synchronize only this block
            c++;
        }
    }

    // Method to get counter value
    public int get() {
        return c;
    }
}
public class SynchronizedBlockTest {
    public static void main(String[] args) {
        Counter cnt = new Counter(); // Shared resource

        // Thread 1 to increment counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cnt.inc();
            }
        });

        // Thread 2 to increment counter
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cnt.inc();
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final counter value
        System.out.println("Counter: " + cnt.get());
    }
}
```