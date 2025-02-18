// all the exception are sub classes of Throwable class in java

public class exceptionHandling {
    public static void main(String[] args) {
        // handling exception using try-catch block
        int a, b, c;
        a = 10;
        b = 0;
        try {
            // c = a / b; // throws arithmetic exception
            // divide(a, b);

            // for custom exception handling
            String message = "This is my custom exception message";
            // if message string contains owrd "custom" then throw below exception
            if (message.contains("custom")) {
                throw new Exception("This is my own custom exception");
            }
        } catch (MyException custom) {
            System.out.println(custom.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace(); // gives full structure of an exception thrown
        } finally {
            // only one finally block is created in try-catch block
            // this block inlcudes code cleaning and closing resources
            System.out.println("this will run irrespective of exception is caught or not");
        }
    }

    // use of throws keyword to method that might throw exception on calling
    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            // throow keyword is used to explicitly throw an exception
            throw new ArithmeticException("Divide by zero exception");
        }
        return a / b;
    }
}

// created own exception or user defined exception by extending Exception class
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}