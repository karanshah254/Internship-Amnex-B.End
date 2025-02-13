import java.util.Arrays;

public class array_1D {

    public static void main(String[] args) {
        char vowels[] = new char[5];

        vowels[0] = 'A';
        vowels[1] = 'E';
        vowels[2] = 'I';
        vowels[3] = 'O';
        vowels[4] = 'U';

        System.out.println("Vowels are: " + Arrays.toString(vowels));

        char newVowels[] = { 'A', 'E', 'I', 'O', 'U' };

        System.out.print("new vowels list is " + Arrays.toString(newVowels));
    }
}