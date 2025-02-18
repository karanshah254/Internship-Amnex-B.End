import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            array.add(i + 1);
        }

        // arr.forEach((item) -> System.out.println(item * 2)); // directly passing
        // lambda function/expression

        // can also pass consumer type
        Consumer<Integer> newArray = (item) -> System.out.println(item * 2);
        // array.forEach(newArray);

        // calling using lambda functions
        Operation sum = (a, b) -> (a + b);
        Operation product = (a, b) -> (a * b);

        LambdaFunctions myCalculator = new LambdaFunctions();
        System.out.println(myCalculator.operate(5, 3, sum)); // 8
        System.out.println(myCalculator.operate(4, 5, product)); // 20
    }

    private int operate(int a, int b, Operation op) {
        return op.operation(a, b);
    }
}

// can also be done using interface
interface Operation {
    int operation(int a, int b);
}