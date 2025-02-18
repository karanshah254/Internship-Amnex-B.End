import java.util.LinkedList;
import java.util.Queue;

public class producer_connsumer_synchronization {
    private Queue<Integer> queue;
    private int capacity;

    public producer_connsumer_synchronization(int cap) {
        queue = new LinkedList<>();
        capacity = cap;
    }

    public boolean add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                // code to be applied when the queue is full
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            queue.add(item);
            queue.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
                // code for empty queue
                // wait until one item has been added
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            int removedElement = queue.poll();
            queue.notifyAll();
            return removedElement;
        }
    }
}
