class StaticBlock {
    // this is used to show initialization of static variable
    static int num1 = 4;
    static int num2;

    // will only run once when class is loaded
    static {
        System.out.println("This is static block");
        num2 = num1 * 10; // this will be executed before main method
    }

    public static void main(String[] args) {
        StaticBlock object = new StaticBlock();
        System.out.println(StaticBlock.num1 + " " + StaticBlock.num2);

        StaticBlock.num2 += 3; // this will be executed after static block

        StaticBlock object2 = new StaticBlock(); // new object created but static block will not run again
        System.out.println(StaticBlock.num2); // print 43
    }
}