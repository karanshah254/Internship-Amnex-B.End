public class Object_demo {
    int num;
    float gpa;

    public Object_demo(int number, float gpa) {
        this.num = number;
        this.gpa = gpa;
    }

    @Override
    public int hashCode() {
        // more in hasmap section
        return super.hashCode(); // gives random number
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((Object_demo) obj).num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Object_demo object1 = new Object_demo(12, 45.5f);
        Object_demo object2 = new Object_demo(12, 56.5f);

        if (object1.equals(object2)) {
            System.out.println("Objects are equal");
        }

        // means object1 is isntance/object for class Object_demo
        System.out.println(object1 instanceof Object_demo); // true

        // get-class of an object
        System.out.println(object1.getClass()); // gives Object_demo
    }
}
