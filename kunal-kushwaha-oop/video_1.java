public class video_1 {
    public static void main(String[] args) {
        // created an instance or onject of class Student using "new" keyword
        // assigning values using constructor
        Student student_1 = new Student("John Doe", 1, 90.5f);

        // System.out.println(student_1);

        // if not assigned by defualt value will be 0 or null depending on data ttpe
        // System.out.println(student_1.roll_no);
        // System.out.println(student_1.name);
        // System.out.println(student_1.marks);

        // student_1.name = "John Doe"; // assinging values for objectusing "." operator
        // student_1.roll_no = 1;
        // student_1.marks = 90.5f;
        // System.out.println(student_1.name);
        // System.out.println(student_1.roll_no);
        // System.out.println(student_1.marks);

        System.out.printf("Name is %s, roll number is %d and marks are %.2f\n", student_1.name, student_1.roll_no,
                student_1.marks);

        Student student_2 = new Student(student_1); // paasing object as parameter
        // System.out.println(student_2.name);
        student_2.greeting(student_2.name);
        student_2.changeName("Jane Doe");
    }
}

// creating a student class for single student
class Student {

    // this are called as instance variable or object variable
    int roll_no;
    String name;
    float marks = 90;
    // it will overlap the value assign in main() method so on on printing it will
    // print 90.0

    // constructor is special type of method/functions which is used to assign
    // values to object
    Student(String s_name, int s_rollNo, float s_marks) {
        // this keyword is used to refer to the current object
        this.name = s_name;
        this.roll_no = s_rollNo;
        this.marks = s_marks;
    }

    // passing object as parameter
    Student(Student other) {
        this.name = other.name;
        this.roll_no = other.roll_no;
        this.marks = other.marks;
    }

    // method to greet the student and calling it using object
    void greeting(String name) {
        System.out.println("Hello " + name);
    }

    void changeName(String name) {
        this.name = name;
        System.out.println("Hello " + name);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed by garbage collector");
    }
}