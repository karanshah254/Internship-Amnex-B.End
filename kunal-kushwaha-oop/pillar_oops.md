## About inheritance
- >Inheritance is property that child class inherit the properties and methods of base/parent class.
- >Defined as process of one class inherit the properties and methods from another class.
- >It is implemented using **"extend"** keyword.
- >It is is-a relationship with objects.

## About polymorphism
- >It means many ways to represent the things or data.
- >It occur during inheritance.
- >Types of polymorphism:
**1. Compile time:**
- >Static or Compile-time Polymorphism when the compiler is able to determine the actual function, it’s called compile-time polymorphism. Compile-time polymorphism can be achieved by method overloading in java. When different functions in a class have the same name but different signatures, it’s called method overloading. A method signature contains the name and method arguments. So, overloaded methods have different arguments. The arguments might differ in the numbers or the type of arguments.
**2. Run time:**
- >Dynamic or Run-time Polymorphism Dynamic (or run-time) polymorphism occurs when the compiler is not able to determine at compile-time which method (superclass or subclass) will be called. This decision is made at run-time. Run-time polymorphism is achieved through method overriding, which happens when a method in a subclass has the same name, return type, and parameters as a method in its superclass. When the superclass method is overridden in the subclass, it is called method overriding.

## About Encapsulation
- >Encapsulation is the process of wrapping code and data together into a single unit.
- >In order to achieve encapsulation in java follow certain steps as proposed below:
    1. Declare the variables as private.
    2. Declare the setters and getters to set and get the variable values.

## About Abstraction
- >Abstraction is a process of hiding implementation details and exposing only the functionality to the user. In abstraction, we deal with ideas and not events. This means the user will only know “what it does” rather than “how it does”.
- >There are two ways to achieve abstraction in Java:
    1. Abstract class (0 to 100%)
    2. Interface (100%)