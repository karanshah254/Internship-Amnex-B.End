// Outer class can't be static but inner class can be static

public class InnerClasses {
    static class Test {
        String name;

        Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            // it will return name rather than some random characters.
            return name;
        }
    }

    public static void main(String[] args) {
        Test test = new Test("John");
        System.out.println(test); // it will print "name" rather than some random characters.
        // System.out.println(test.name);
    }
}
