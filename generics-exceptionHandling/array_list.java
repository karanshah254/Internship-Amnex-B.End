public class array_list {
    private int[] data;
    private int size = 0;
    private int DEFAULT_SIZE = 10;

    private array_list() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];

        // copy current items in new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove() {
        int removed = data[--size];
        return removed;
    }

    public int get(int index) {
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public String toString() {
        return java.util.Arrays.toString(data);
    }

    public static void main(String[] args) {
        // array list ans its methods
        array_list list = new array_list();

        // list.add(24);
        // list.add(34);
        // list.add(30);

        for (int i = 0; i < 14; i++) {
            list.add(2 * (i + 1));
        }

        System.out.println(list);
    }
}
