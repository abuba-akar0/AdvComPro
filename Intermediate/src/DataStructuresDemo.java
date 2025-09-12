import java.util.*;
import java.util.Arrays;

public class DataStructuresDemo {
    public static void main(String[] args) {
        // Array
        int[] numbers = {1, 2, 3};
        System.out.println("Array: " + Arrays.toString(numbers));

        // ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        System.out.println("ArrayList: " + list);

        // LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("First");
        linkedList.add("Second");
        System.out.println("LinkedList: " + linkedList);

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack: " + stack);
        stack.pop();

        // Queue
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        System.out.println("Queue: " + queue);
        queue.poll();

        // HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println("HashMap: " + map);

        // HashSet
        HashSet<String> set = new HashSet<>();
        set.add("Red");
        set.add("Blue");
        System.out.println("HashSet: " + set);
    }
}

