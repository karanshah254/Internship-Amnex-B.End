public class states_thread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                for (int i = 1000; i > 0; i--)
                    ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "States");

        thread1.start();

        while (true) {
            Thread.State state = thread1.getState();
            System.out.println(state); // prints state from RUNNABLE to TERMINATED
            if (state == Thread.State.TERMINATED) {
                break;
            }
        }
    }
}
