public class video_3 {
    public static void main(String[] args) {
        // Box box = new Box(); // zero argument constructor
        // // box.display();

        // Box box1 = new Box(23, 45, 65); // htree argument constructor
        // // box1.display();

        // Box box2 = new Box(box1); // passing any object as parameter
        // box2.display();

        // WeightBox newBox = new WeightBox(2, 3, 4, 5);
        // newBox.display(); // child class is calling parent class method and it is
        // working fine

        // Box box = new WeightBox(2, 3, 4, 5);
        // System.out.println(box.weight); // it is not possible as it is type of Box
        // and Box does not have weight

        // WeightBox box = new Box(); // it is not possible as it is type of WeightBox and Box does not have weight
    }
}

class Box {
    double length;
    double width;
    double height;

    Box() {
        this.length = -1;
        this.width = -1;
        this.height = -1;
    }

    // for cube
    Box(double side) {
        this.length = side;
        this.width = side;
        this.height = side;
    }

    Box(double length, double width, double height) {
        super(); // calls the main class that is "Object" class
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // pass an object
    Box(Box object) {
        this.length = object.length;
        this.width = object.width;
        this.height = object.height;
    }

    public void display() {
        System.out.println("Length: " + length + " Width: " + width + " Height: " + height);
    }
}

class WeightBox extends Box {
    // we can use length, height, and width also
    double weight;

    public WeightBox() {
        this.weight = -1;
    }

    public WeightBox(double length, double width, double height, double weight) {
        super(length, width, height); // calling super class or base class constructor i.e Box
        this.weight = weight;
        System.out.println("Weight is: " + weight);
        // System.out.println(super.weight); // if parent class also have weight property the super.weight is called
    }
}