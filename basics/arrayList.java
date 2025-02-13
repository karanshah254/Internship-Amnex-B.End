import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<Integer>();

        // Adding elements to the ArrayList
        number.add(10);
        number.add(20);
        number.add(30);
        number.add(40);

        // get single element
        System.out.println("\nElement at index 2 is " + number.get(2));

        // remove specific element from index
        // System.out.println("Removing element at index 2 is " + number.remove(2));

        // get full arraylist
        System.out.println("Array is " + number.toString());

        // update the value
        System.out.println("Updating element " + number.set(2, 50));

        System.out.println(number.toString());

        // size of arrayList
        System.out.println("number of elements in array list is" + number.size());

        // check if arrayList contains certain value or not
        System.out.println("Does array list have 20 ? " + number.contains(20));

        // clears the array list
        number.clear();
        
        // checks if array list is empty or not
        System.out.println("Us array list empty ? " + number.isEmpty());
    }
}
