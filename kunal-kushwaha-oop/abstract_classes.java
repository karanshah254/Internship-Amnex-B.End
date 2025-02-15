public class abstract_classes {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.typeOFWalk();

        Parent career = new Child();
        career.career("Java developer");
    }
}

abstract class Animal {
    abstract void typeOFWalk(); // declare abstract method thats is just function not implementation
}

class Dog extends Animal {
    // implementing abstract method
    void typeOFWalk() {
        System.out.println("Dog walks on 4 legs");
    }
}

class Cat extends Animal {
    void typeOFWalk() {
        System.out.println("Cat walks on 4 legs");
    }
}

abstract class Parent {
    // declared the function which must be ovveride in child class
    abstract void career(String name);
}

class Child extends Parent {
    // overrride child class
    void career(String name) {
        System.out.println("Child is a " + name);
    }
}