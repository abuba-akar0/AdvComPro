import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "Student{name='" + name + "', id=" + id + "}";
    }
}

public class MiniProject {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Management System");
        while (true) {
            System.out.print("Enter student name (or 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            System.out.print("Enter student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            students.add(new Student(name, id));
        }

        System.out.println("All students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

