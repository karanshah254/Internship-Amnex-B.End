public class join_threads {
    public static void main(String[] args) {
        System.out.println("main has been started");

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } // main thread will wait for thread to complete

        // know priority of thread
        System.out.println(thread.getPriority());
        // set priority of thread
        thread.setPriority(10);
        System.out.println(thread.getPriority());

        System.out.println("main has been ended");
    }
}
