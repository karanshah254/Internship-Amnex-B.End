public class compiletime_poly {

    // implementing method overloading
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        compiletime_poly objects = new compiletime_poly();
        System.out.println(objects.sum(1, 2));
        System.out.println(objects.sum(1, 2, 4));
    }
}
