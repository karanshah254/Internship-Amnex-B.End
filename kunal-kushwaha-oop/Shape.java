public class Shape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.area();
    }
}

class Circle extends Shape {
    public void area() {
        System.out.println("Area of circle");
    }
}

class Rectange extends Shape {
    public void area() {
        System.out.println("Area of rectangle");
    }
}