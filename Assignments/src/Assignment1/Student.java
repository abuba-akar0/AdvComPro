package Assignment1;

public class Student {
    int rollNo;
    String name;
    int[] marks = new int[3];

    int getTotal() {
        return marks[0] + marks[1] + marks[2];
    }

    double getAverage() {
        return getTotal() / 3.0;
    }
}
