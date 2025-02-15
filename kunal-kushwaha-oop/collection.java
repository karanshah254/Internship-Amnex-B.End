import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class collection {
    public static void main(String[] args) {
        // object of child class can have reference of parent class
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println(list);

        List<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3); // simillar to  array-list but it is sychronized
    }
}
