// multiple inheritance using interface is done
// interface is a blueprint of a class

public class interface_demo implements Engine, Brake {
    public void start() {
        System.out.println("Engine started");
    }

    public void stop() {
        System.out.println("Engine stopped");
    }

    public void accelarate() {
        System.out.println("Engine accelarated");
    }

    public void brake() {
        System.out.println("Brake applied");
    }

    public static void main(String[] args) {
        // Interface_demo object = new Interface_demo();
        // object.start();
        // object.accelarate();
        // object.brake();
        // object.stop();

        NiceCar car = new NiceCar();
        car.start(); // default power engine
        car.startMusic();
        car.upgradeEngine(); // change to electric engine
        car.start();

        Engine.hello(); // calling static method of interface

    }
}

interface Brake {
    void brake();
}

interface Engine {
    static final int PRICE = 55000;

    void start();

    void stop();

    void accelarate();

    // static methods in interface must have body of code
    // call via interface name
    static void hello() {
        System.out.println("Hello from Engine");
    }
}

interface Media {
    void start();

    void stop();
}

class CDPlayer implements Media {
    public void start() {
        System.out.println("CDPlayer started");
    }

    public void stop() {
        System.out.println("CDPlayer stopped");
    }
}

class PowerEngine implements Engine {
    public void start() {
        System.out.println("PowerEngine started");
    }

    public void stop() {
        System.out.println("PowerEngine stopped");
    }

    public void accelarate() {
        System.out.println("PowerEngine accelarated");
    }
}

class ElectricEngine implements Engine {
    public void start() {
        System.out.println("ElectricEngine started");
    }

    public void stop() {
        System.out.println("ElectricEngine stopped");
    }

    public void accelarate() {
        System.out.println("ElectricEngine accelarated");
    }
}

class NiceCar {
    private Engine engine;
    private Media media = new CDPlayer();

    public NiceCar() {
        engine = new PowerEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic() {
        media.start();
    }

    public void stopMusic() {
        media.stop();
    }

    public void upgradeEngine() {
        this.engine = new ElectricEngine();
    }
}