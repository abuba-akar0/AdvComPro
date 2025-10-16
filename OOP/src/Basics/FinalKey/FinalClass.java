package Basics.FinalKey;

public class FinalClass {
    public final int a = 10;
    public final int b = 20;

    public static final int c = 30;
    public static final int d = 40;

    public final void sayHello() {
        System.out.println("Hello Final World");
        int sum = a + b;
        System.out.println("Sum is: " + sum);

        int sum2 = c + d;
        System.out.println("Sum2 is: " + sum2);
    }



    public static void main(String[] args) {
        System.out.println("This is a final class example.");
        FinalClass obj = new FinalClass();
        obj.sayHello();
    }
}
