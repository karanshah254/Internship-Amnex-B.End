public class multilevel_inheritance {
    public static void main(String[] args) {
        C c = new C();
        c.displayC();
    }
}

class A {
    public void displayA() {
        System.out.println("A");
    }
}

class B extends A {
    public void displayB() {
        // super.displayA();
        System.out.println("B");
    }
}

class C extends B {
    public void displayC() {
        super.displayA();
        super.displayB();
        System.out.println("C");
    }
}