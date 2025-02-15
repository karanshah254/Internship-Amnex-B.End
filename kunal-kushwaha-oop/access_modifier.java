public class access_modifier {
    public static void main(String[] args) {
        A a = new A("John", 23);
        // Object obj = new Object(); // root of all classes exist in this package

        // a.name; // Error: name has private access in A
        // System.out.println(a.getName()); // will give name of an object A (name is
        // private)

        // use of setter method to set the value of private variable
        // a.setName("Jane");

        // for protecttive modifier: access within same package and its subclasses only.
        a.display();
    }
}

class A {
    private String name; // private modifier
    public int number; // public modifier
    String color; // default modifier

    public A(String name, int number) {
        this.name = name;
        this.number = number;
    }

    // we can access private methods and data using getters and setters
    public String getName() {
        return "Name :" + name;
    }

    // we can also set the value of private variable using setter method
    public void setName(String newName) {
        this.name = newName;
        System.out.println("Name has been updated to: " + name);
    }

    protected void display() {
        System.out.println("A class");
    }
}