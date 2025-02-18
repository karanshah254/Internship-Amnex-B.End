public class creating_Deadlock {
    public static void main(String[] args) {
        System.out.println("main has been started");

        String lock1 = "john";
        String lock2 = "doe";

        // created a deadlock in threads, it's not a good practice of code
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                synchronized (lock2) {
                    System.out.println("lock1 and lock2 are acquired by thread1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (lock1) {
                    System.out.println("lock2 and lock1 are acquired by thread2");
                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("main has been ended");
    }
}
