

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        int number = new java.util.Scanner(System.in).nextInt();
        System.out.printf("The number is: %d%n", number);
        System.out.printf("The square of the number is: %d%n", number * number);

        System.out.printf("The cube of the number is: %d%n", number * number * number);
    }
}