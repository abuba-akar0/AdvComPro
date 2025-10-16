package Basics.Static_NonStatic;

public class StaticHello {
    public static int a = 10;
    public static int b = 20;
    public static void sayHello() {
        System.out.println("Hello Static World");
        int sum = a + b;
        System.out.println("Sum is: " + sum);
    }
    public static void main(String[] args) {
        a=2;
        sayHello();
    }
}
