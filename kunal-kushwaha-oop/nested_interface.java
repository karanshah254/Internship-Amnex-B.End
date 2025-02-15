public class nested_interface {
    public interface NestedInterface {
        boolean isOdd(int num);
    }

    public static void main(String[] args) {
        newClass obj = new newClass();
        System.out.println(obj.isOdd(5)); // true
        System.out.println(obj.isOdd(2)); // falsex
    }
}

class newClass implements nested_interface.NestedInterface {
    public boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
