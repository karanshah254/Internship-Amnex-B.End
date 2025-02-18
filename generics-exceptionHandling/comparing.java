import java.util.Arrays;
// import java.util.Comparator;

public class comparing implements Comparable<comparing>, GenericInterface<Integer> {
    // consider class of Student
    int roll_no;
    float marks;

    public comparing(int rollNo, float marks) {
        this.roll_no = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "marks=" + marks;
    }

    public static void main(String[] args) {
        comparing john = new comparing(12, 95.4f);
        comparing jane = new comparing(13, 92.4f);
        comparing peter = new comparing(19, 88.9f);

        comparing[] students = { john, jane, peter };

        // System.out.println(Arrays.toString(students));

        // Arrays.sort(students, new Comparator<comparing>() {
        // @Override
        // public int compare(comparing o1, comparing o2) {
        // return (int) (o1.marks - o2.marks);
        // // return -(int) (o1.marks - o2.marks); // ascending order
        // }
        // });

        // use of lambda expression for same sort
        Arrays.sort(students, (o1, o2) -> (int) (o1.marks - o2.marks));

        // ascending order based on marks
        System.out.println(Arrays.toString(students));

        // if(peter.compareTo(john) < 0) {
        // System.out.println(peter.compareTo(john));
        // System.out.println("john has more marks");
        // } else {
        // System.out.println(peter.compareTo(john));
        // System.out.println("pater has more marks");
        // }
    }

    @Override
    public void display(Integer value) {

    }

    @Override
    public int compareTo(comparing o) {
        int diff = (int) (this.marks - o.marks);
        // if diff is 0, then both are equal
        // if diff < 0 then this o is bigger else o is smaller
        return diff;
    }
}

interface GenericInterface<T> {
    void display(T value);
}
