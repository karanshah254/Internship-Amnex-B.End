## What are packages?
- >Packages are containers used in java to organize the code and file structure
- >Packages in Java are a mechanism that encapsulates a group of classes, sub-packages, and interfaces.
- >Example:
```java
package com.oop.inheritance;
```

## Import statement
- >The keyword "import" is used to import the necessary packages or java libraries.

## Static keyword in java
- >The static keyword in Java is mainly used for memory management. The static keyword in Java is used to share the same variable or method of a given class. The users can apply static keywords with variables, methods, blocks, and nested classes. The static keyword belongs to the class rather than an instance of the class. The static keyword is used for a constant variable or a method that is the same for every instance of a class.
- >Characteriestics:
    1. **Shared memory allocation**: Static variables and methods are allocated memory space only once during the execution of the program. This memory space is shared among all instances of the class, which makes static members useful for maintaining global state or shared functionality.

    2. **Accessible without object instantiation**: Static members can be accessed without the need to create an instance of the class. This makes them useful for providing utility functions and constants that can be used across the entire program.
    
    3. **Associated with class, not objects**: Static members are associated with the class, not with individual objects. This means that changes to a static member are reflected in all instances of the class, and that you can access static members using the class name rather than an object reference.
    
    4. **Cannot access non-static members**: Static methods and variables cannot access non-static members of a class, as they are not associated with any particular instance of the class.
    
    5. **Can be overloaded, but not overridden**: Static methods can be overloaded, which means that you can define multiple methods with the same name but different parameters. However, they cannot be overridden, as they are associated with the class rather than with a particular instance of the class.
- >Static methods can be called inside non-static as well as static ones.
- >Use of "this" keyword is prohibited as static involves no object creation.

## What are SingleTon classes ?