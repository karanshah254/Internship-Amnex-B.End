public class strings_in_java {
    public static void main(String[] args) {
        String str = "John";

        System.out.println(String.format("Hello %s", str)); // to use %s instead of concatenation

        System.out.printf("hello %s\n", str); // wihtout using String.format

        // check if string is empty
        System.out.println("Is string empty "+ str.isEmpty());

        System.out.printf("Length of string is " + str.length());
    }
}
