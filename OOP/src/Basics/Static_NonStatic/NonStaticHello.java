package Basics.Static_NonStatic;

public class NonStaticHello {
    public int a = 10;
    public int b = 20;
    public void sayHello() {
        System.out.println("Hello Non-Static World");
        int sum = a + b;
        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
        NonStaticHello obj = new NonStaticHello();
        obj.sayHello();
    }
}
