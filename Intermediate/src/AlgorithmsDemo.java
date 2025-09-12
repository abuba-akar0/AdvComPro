import java.util.Arrays;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5};
        bubbleSort(arr);
        System.out.println("Bubble sorted: " + Arrays.toString(arr));

        int index = linearSearch(arr, 9);
        System.out.println("Linear search for 9: " + index);

        int[] arr2 = {1, 2, 5, 5, 9};
        int binaryIndex = binarySearch(arr2, 5);
        System.out.println("Binary search for 5: " + binaryIndex);

        System.out.println("Recursion (factorial 5): " + factorial(5));
    }

    // Bubble sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary search (array must be sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Recursion: factorial
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}

