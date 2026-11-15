
import java.util.Scanner;

class Student {

    private String name;
    private int m1, m2, m3;

    Student(String name) {
        this.name = name;
    }

    boolean setMarks(int a, int b, int c) {

        if (a < 0 || a > 100 ||
            b < 0 || b > 100 ||
            c < 0 || c > 100) {

            return false;
        }

        m1 = a;
        m2 = b;
        m3 = c;

        return true;
    }

    int getTotal() {
        return m1 + m2 + m3;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getGrade() {

        double avg = getAverage();

        if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 40)
            return "D";
        else
            return "F";
    }

    public String toString() {

        return name + " total=" + getTotal()
                + " avg=" + String.format("%.2f", getAverage())
                + " grade=" + getGrade();
    }
}

public class Problem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            String name = sc.next();

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            Student s = new Student(name);

            if (s.setMarks(a, b, c)) {

                students[count] = s;
                count++;
            }
            else {
                System.out.println(name + " skipped: marks must be 0 to 100");
            }
        }

        int passes = 0;

        // Bubble Sort - Descending order
        for (int i = 0; i < count - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < count - 1 - i; j++) {

                if (students[j].getTotal() <
                    students[j + 1].getTotal()) {

                    Student temp = students[j];

                    students[j] = students[j + 1];

                    students[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            passes++;
        }

        System.out.println("\nRanked List:");

        for (int i = 0; i < count; i++) {

            System.out.println((i + 1) + ". " + students[i]);
        }

        System.out.println("Sorted in " + passes + " passes");

        sc.close();
    }
}
