import java.util.ArrayList;
import java.util.Comparator;


public class sort_arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);

        list.sort(Comparator.naturalOrder()); // Ascending order using corresponding values

        // list.sort(Comparator.reverseOrder()); // Descending order using corresponding values
        System.out.println(list.toString());
    }
}
