
import java.util.Scanner;

public class Problem3 {

    static String[] pile = new String[3];
    static int top = -1;

    static String[] queue = new String[3];
    static int front = 0;
    static int rear = -1;
    static int count = 0;

    static void returnBook(String book) {

        if (top == 2) {
            System.out.println(book + " rejected: pile is full");
        }
        else {
            top++;
            pile[top] = book;

            System.out.println(book + " placed on pile");
        }
    }

    static void shelveBook() {

        if (top == -1) {
            System.out.println("pile is empty");
        }
        else {
            System.out.println("shelved " + pile[top]);

            pile[top] = null;
            top--;
        }
    }

    static void waitStudent(String name) {

        if (count == 3) {
            System.out.println(name + " rejected: line is full");
        }
        else {

            rear = (rear + 1) % 3;

            queue[rear] = name;

            count++;

            System.out.println(name + " joined the line");
        }
    }

    static void serveStudent() {

        if (count == 0) {
            System.out.println("no one waiting");
        }
        else {

            System.out.println("served " + queue[front]);

            queue[front] = null;

            front = (front + 1) % 3;

            count--;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of commands: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {

            String command = sc.nextLine().trim();

            String[] parts = command.split("\\s+", 2);

            String operation = parts[0];

            switch (operation) {

                case "RETURN":
                    returnBook(parts[1]);
                    break;

                case "SHELVE":
                    shelveBook();
                    break;

                case "WAIT":
                    waitStudent(parts[1]);
                    break;

                case "SERVE":
                    serveStudent();
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}
