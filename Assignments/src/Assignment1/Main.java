package Assignment1;
import java.util.*;

public class Main {
    static Student[] students = new Student[50];
    static int studentCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Marks");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student");
            System.out.println("6. Highest Scorer");
            System.out.println("7. Class Average");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateMarks(); break;
                case 3: removeStudent(); break;
                case 4: viewAllStudents(); break;
                case 5: searchStudent(); break;
                case 6: highestScorer(); break;
                case 7: classAverage(); break;
                case 8:
                    System.out.println("Exiting... Total students: " + studentCount);
                    classAverage();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addStudent() {
        if (studentCount >= 50) {
            System.out.println("Cannot add more students (limit reached).");
            return;
        }

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        // check uniqueness
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNo == roll) {
                System.out.println("Roll number already exists! Student not added.");
                return;
            }
        }

        sc.nextLine(); // consume leftover newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter Marks in Subject " + (i+1) + ": ");
                int m = sc.nextInt();
                if (m >= 0 && m <= 100) {
                    marks[i] = m;
                    break;
                } else {
                    System.out.println("Invalid marks! Must be between 0 and 100.");
                }
            }
        }

        Student s = new Student();
        s.rollNo = roll;
        s.name = name;
        s.marks = marks;
        students[studentCount++] = s;

        System.out.println("Student added successfully!");
    }

    static void updateMarks() {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();

        Student found = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNo == roll) {
                found = students[i];
                break;
            }
        }

        if (found == null) {
            System.out.println("Roll number not found!");
            return;
        }

        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter New Marks in Subject " + (i+1) + ": ");
                int m = sc.nextInt();
                if (m >= 0 && m <= 100) {
                    found.marks[i] = m;
                    break;
                } else {
                    System.out.println("Invalid marks! Must be between 0 and 100.");
                }
            }
        }

        System.out.println("Marks updated successfully!");
    }

    static void removeStudent() {
        System.out.print("Enter Roll No to remove: ");
        int roll = sc.nextInt();

        int pos = -1;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNo == roll) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Roll number not found!");
            return;
        }

        for (int i = pos; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        studentCount--;

        System.out.println("Student removed successfully!");
    }

    static void viewAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s %-10s%n",
                "Roll No", "Name", "Sub1", "Sub2", "Sub3", "Total", "Average");

        for (int i = 0; i < studentCount; i++) {
            Student s = students[i];
            System.out.printf("%-10d %-15s %-10d %-10d %-10d %-10d %-10.2f%n",
                    s.rollNo, s.name, s.marks[0], s.marks[1], s.marks[2],
                    s.getTotal(), s.getAverage());
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNo == roll) {
                Student s = students[i];
                System.out.printf("Roll No: %d, Name: %s, Marks: [%d, %d, %d], Total: %d, Average: %.2f%n",
                        s.rollNo, s.name, s.marks[0], s.marks[1], s.marks[2], s.getTotal(), s.getAverage());
                return;
            }
        }

        System.out.println("Roll number not found!");
    }

    static void highestScorer() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        Student top = students[0];
        for (int i = 1; i < studentCount; i++) {
            if (students[i].getTotal() > top.getTotal()) {
                top = students[i];
            }
        }

        System.out.println("Highest Scorer: " + top.name + " (Roll No: " + top.rollNo +
                ", Total: " + top.getTotal() + ")");
    }

    static void classAverage() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }

        int sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += students[i].getTotal();
        }

        double avg = sum / (studentCount * 3.0);
        System.out.printf("Class Average: %.2f%n", avg);
    }
}
