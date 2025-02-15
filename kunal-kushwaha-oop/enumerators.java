public class enumerators {
    enum Week implements A {
        // these are enums constants and by defaukt they are public, static, final
        // since it is final then you can't create a child enums
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
        // type is week

        // can override interface
        @Override
        public void hello() {
            System.out.println("Hello");
        }

        // in enumes we can't create an abstract method
        // void show(); // is not possible
    }

    public static void main(String[] args) {
        // defining enums in java
        Week week;

        week = Week.Monday;
        // System.out.println(week);

        // for (Week day : Week.values()) {
        //     System.out.println(day);
        // }

        week.hello();
    }
}

interface A {
    void hello();
}