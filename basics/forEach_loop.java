import java.util.ArrayList;

public class forEach_loop {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);

        // using for-each loop to iterate over the array
        System.out.println("Using for-each loop to iterate over array list");
        array.forEach(number -> {
            System.out.printf("%d X %d = %d\n", number, number, number * number);
        });
    }
}
