
import java.util.Scanner;

public class Problem1 {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node build(String[] stops) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < stops.length; i++) {

            Node newNode = new Node(stops[i]);

            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {

        Node temp = head;

        int count = 0;
        String first = "";
        String last = "";

        while (temp != null) {

            if (count == 0) {
                first = temp.data;
            }

            last = temp.data;

            System.out.print(temp.data + " -> ");

            count++;

            temp = temp.next;
        }

        System.out.println("null");

        System.out.println("Stops: " + count
                + ", First: " + first
                + ", Last: " + last);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stops: ");
        int n = sc.nextInt();

        String[] stops = new String[n];

        System.out.println("Enter stop names:");

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);

        printRoute(head);

        sc.close();
    }
}
