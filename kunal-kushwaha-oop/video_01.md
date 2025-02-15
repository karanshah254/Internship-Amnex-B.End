## About classes and objects
- >**Class**: It defined as logical construct or blue print of any template. It doesn't occupy space in memory
- >**Object**: Defines the instance of the class. It is real entity. It take space in memory.
- >Sample code:
```java
class Student {
    int roll_no;
    String name;
    float marks;
}
// psvm main class
main() {
    Student student_1 = new Student();
}
```
- >As per above code, Student is class name and student_1 is instance or reference varuable of that class. By using **new** keyword we are creating an instance which can be used to use the instance variable of that class.

### How to access the class properties/variables
- >It can be implemented using "." operator in java.
- >Example: 
```java 
student_1.name = "value-in-string";
student_1.roll_no = "number"
student_1.marks = "marks-out-of-100"
```
- >Also in class itself we can be assign the value. For example:
```java 
class Student { 
    String name = "john";
}
```

### About null or 0 values
- >If instance variable or object is not assgined initially then on printing its value it will give an output as 0 or null depend on datt type used.
```java
System.out.println(student_1.name); // wil give null as output
```
- >We can use "." operator to assign value.
```java
student_1.name = "John";
System.out.println(student_1.name); // now it will print john
```

### Assigning values on object creation
- >We can do this by using constructor of same class.
- >Make sure that construcor name is same as class name given
- >For our example:
```java
class Student {
    String name;

    void changeName(String name) {
        this.name = name;
    }
    Student(String f_name) {
        this.name = f_name;
    }
}

main() {
    // here Student() is constructor which is used to initalize objects.
    Student student = new Student("John");
    System.out.println(student.name); // gives john
    student.changeName("Jane");
}
```

### How to call a conctructor within another constructor
- >Example:
```java
class Student {
    Student() {
        // calling below constructor
        this("John");
    }
    Student(String name) {
        this.name = name;
    }
}

main() {
    // internally callled new Student("John");
    Student s = new Student() ;
    System.out.println(s.name)
}
```

### What is final keyword?
- >Final keyword is used for variable which need not to be modified
- >Primitive datatype cannot be modified using final keyword
- >Other than primitive datatype variable can be modified

### What is finallize() method ?
- >This method is called whenever we need to destroy the object or its instances.
- >It is same as garbage collector in java, instead java calls it automatically whenever required.