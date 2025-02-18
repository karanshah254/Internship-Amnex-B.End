public class VolatileTest {
    // volatile keyword is used to make sure that the instance variable is
    // consistent and correctly updated by both threads.
    private static volatile VolatileTest instance = null;

    private VolatileTest() {
        System.out.println("Instance created");
    }

    public static VolatileTest getInstance() {
        if(instance == null) { // optimization
            synchronized(VolatileTest.class) { // thread 2
                if(instance == null) {
                    instance = new VolatileTest();
                }
            }
        }
        return instance;
    }
}