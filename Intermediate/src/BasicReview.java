public class BasicReview {
    public static void main(String[] args) {
        // Variables and data types
        int number = 10;
        double price = 19.99;
        String message = "Hello, Java!";
        boolean isActive = true;

        // Control structures
        if (number > 5) {
            System.out.println("Number is greater than 5");
        } else {
            System.out.println("Number is 5 or less");
        }

        // Loops
        for (int i = 0; i < 3; i++) {
            System.out.println("Loop iteration: " + i);
        }

        // Functions
        int sum = add(5, 7);
        System.out.println("Sum: " + sum);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}

