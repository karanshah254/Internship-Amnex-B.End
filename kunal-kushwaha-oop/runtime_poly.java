public class runtime_poly {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();
        System.out.println(car.typeOfFuel("Petrol"));

        // this is called upcasting super-class reference variable can hold the object
        // of sub-class
        Vehicle vehicleCar = new Car(); // it is type of car so it called car's run method
        vehicleCar.run();

        // Java used dynamic method dispatch for runtime polymorphism to determine whihc
        // method to call at runtime
    }
}

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }

    String typeOfFuel(String name) {
        return "Vehicle runs on " + name;
    }
}

class Car extends Vehicle {
    // this is called annotation in java which is used to check if the method is
    // overridden or not
    @Override
    void run() {
        System.out.println("Car is running");
    }

    @Override
    String typeOfFuel(String name) {
        return "Car runs on " + name;
    }
}
