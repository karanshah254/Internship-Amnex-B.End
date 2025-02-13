public class datatype {
    public static void main(String[] args) {
        // integer based data types
        byte singleBit = 127; // 8-bit signed integer
        short smallNo = 32767; // 16-bit signed integer
        int integer = 2147483647; // 32-bit signed integer
        long largeNo = 9223372036854775807L; // 64-bit signed integer

        // decimal types
        double doubleNo = 1.3643264234; // 64-bit double-precision floating point
        float floatNo = 3.40f; // 32-bit single-precision floating point

        // boolean types
        boolean isTrue = true; // true or false

        // character types
        char character = '\u00A9'; // 16-bit unicode character
        System.out.println(" this is copyright symbol" + character);
        System.out.println("The value of singleBit is: " + singleBit);
    }
}