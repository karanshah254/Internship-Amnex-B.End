public class encapsulation {
    public static void main(String[] args) {
        Box box = new Box();
        box.getName();
    }
}

class Box {
    // hiding the name variable and making it private
    private String name; // data hiding

    // getting name using getter call
    public String getName() {
        return name;
    }
}