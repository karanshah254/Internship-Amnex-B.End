import java.util.Scanner;

public class input_output {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("\nEnter number: ");
        int input = sc.nextInt();

        sc.nextLine(); // to consume the newline character

        System.out.print("Enter name : ");
        String name = sc.nextLine();

        System.out.println("Number entered is: " + input);
        System.out.println("Name entered is: " + name);

        sc.close(); // close the scanner
    }

}