public class SingleTon {

    private SingleTon() {

    }

    private static SingleTon instance;

    public static SingleTon getInstance() {
        // check wheather if instance is null or not, if null then create one else return the instance present
        if(instance == null) {
            instance = new SingleTon();
        } 
        return instance;
    }

    public static void main(String[] args) {
        SingleTon object = SingleTon.getInstance();
        SingleTon object2 = SingleTon.getInstance(); // it will return the same instance as object
    }
}
