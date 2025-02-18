## How does JVM Handles an exception?
- >Default Exception Handling: When an Exception occurs, the JVM Creates an exception object containing the error name, description, and program state. Creating the Exception Object and handling it in the run-time system is called throwing an Exception. There might be a list of the methods that had been called to get to the method where an exception occurred. This ordered list of methods is called Call Stack. Now the following procedure will happen. 
    - The run-time system searches the call stack for an Exception handler
    - It starts searching from the method where the exception occurred and proceeds backward through the call stack.
    - If a handler is found, the exception is passed to it.
    - If no handler is found, the default exception handler terminates the program and prints the stack trace.

## How programmer handles an exception?
- >Customized Exception Handling: Java exception handling uses five keywords: try, catch, throw and throws, and finally. Code that might cause an exception goes in the try block. If an exception occurs, it is caught using catch. We can throw exceptions manually with throw, and methods must declare exceptions they can throw using throws. The finally block is used for code that must run after try, whether an exception occurs or not.