public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            throw new CustomException("This is a custom exception!");
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

