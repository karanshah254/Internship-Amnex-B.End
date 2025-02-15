public class video_2 {
    // about human properties
    public static void main(String[] args) {
        Human john = new Human(25, "John", 50000);
        Human kenny = new Human(26, "Kenny", 60000);
        Human jane = new Human(0, null, 0);

        // it can be accessed without any reference variable or any object
        System.out.println(Human.population); // will give 3 as output as 3 instances of human class is created
        // System.out.println(kenny.population); // both will work and give output 3

        // method(); // only static method can be called inside main method (main is
        // static method)

        // greeting(); // non-static method can't be called within main class as main
        // class is static.

        Human.message();
    }

    static void method() {
        // it is not dependent on object creation or any reference variable;
        System.out.println("static method is called of video_2(Main) class");

        // greeting(); // it can't be done because it is non-static method and requires
        // object creation

        // to use non static inside static we can follow these steps
        video_2 obj = new video_2();
        obj.greeting(); // created an instance of class and called non-static method
    }

    // this is dependent on object creation so it can't be called in main method
    void greeting() {
        method(); // we can use static method inside non-static method but reverse is not true
        System.out.println("Hello");
    }

}

class Human {
    int age;
    String name;
    int salary;
    static long population; // static variable is shared by all objects of the class

    public Human(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        Human.population++; // population is common for nay humna exist on earth that is 7B.

        // this is callled as sson as all values are assigned
        Human.message(); // static method can be called inside constructor
    }

    static void message() {
        System.out.println("This is a static method of human class");
        // System.out.println(this.age); // this can't be used in static method
    }
}