import java.util.Arrays;

public class objectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human john = new Human(25, "John");
        // Human johnTwin = new Human(john); // copying exact object

        Human johnTwin = (Human) john.clone();
        System.out.println("John's age is " + john.age + " and his twin's age is " + johnTwin.age); // clone object's
                                                                                                    // age
        // System.out.println(Arrays.toString(johnTwin.array));
        johnTwin.array[0] = 100;
        // System.out.println(Arrays.toString(john.array)); // changed zero index of
        // array in both, thus called shallow copy

        // deep copy example
        System.out.println("John's " + Arrays.toString(john.array)); // this is not changed
        System.out.println("His twin " + Arrays.toString(johnTwin.array)); // this is changed
    }
}

// implementing cloneable interface to clone the object
class Human implements Cloneable {
    int age;
    String name;
    int[] array;

    // public Human(Human otherHuman) {
    // this.age = otherHuman.age;
    // this.name = otherHuman.name;
    // }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.array = new int[] { 3, 4, 5, 6, 7 };
    }

    // @Override
    // protected Object clone() throws CloneNotSupportedException {
    // // this is shallow copy
    // return super.clone();
    // }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human johnTwin = (Human) super.clone(); // shallow copy

        // make deep copy
        johnTwin.array = new int[johnTwin.array.length];
        for (int i = 0; i < johnTwin.array.length; i++) {
            johnTwin.array[i] = this.array[i];
        }
        return johnTwin;
    }
}