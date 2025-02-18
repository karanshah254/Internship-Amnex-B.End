## What is use of volatile keyword?
- >Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread-safe. Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.
- >Example:
```java
class SharedObject {
    static int sharedVariable = 10;
    static volatile int newSharedVaribale = 10;
}
```
- >Suppose that two threads are working on **SharedObj**. If two threads run on different processors each thread may have its own local copy of sharedVariable. If one thread modifies its value the change might not reflect in the original one in the main memory instantly. This depends on the write policy of cache. Now the other thread is not aware of the modified value which leads to data inconsistency.