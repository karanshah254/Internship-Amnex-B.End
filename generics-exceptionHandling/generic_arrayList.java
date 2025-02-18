// done T extends Number to make sure only data of types of numbers are been used not string
// here T should be Number or subclass of Number class

import java.util.Arrays;
import java.util.List;

public class generic_arrayList<T extends Number> {
    private Object[] data;
    private int size = 0;
    private int DEFAULT_SIZE = 10;

    private generic_arrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy current items in new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @SuppressWarnings("unchecked")
    public T remove() {
        T removed = (T) (data[--size]);
        return removed;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "Custom ArrayList {"+ "data=" + Arrays.toString(data) + ", size=" + size + "}";
    }

    // use of wildcard
    // ? represent unknown type
    public void getList(List<? extends Number> list) {
        // only pass numbers here
    }

    public static void main(String[] args) {
        // array list ans its methods
        generic_arrayList<Integer> generic_list = new generic_arrayList<>();
        // generic_list.add(24);
        // generic_list.add('asfsf'); // gives error as it is type safe

        for (int i = 0; i < 14; i++) {
            generic_list.add(2 * (i + 1));
        }

        System.out.println(generic_list);
    }
}
