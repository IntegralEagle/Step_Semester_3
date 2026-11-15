
import java.util.Scanner;

public class Problem4 {

    static class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node buildList(String[] bookings) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < bookings.length; i++) {

            Node newNode = new Node(bookings[i]);

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

    static Node removeFirst(Node head, String booking) {

        // Case 1: Empty list
        if (head == null) {
            System.out.println("Booking not found");
            return head;
        }

        // Case 2: Booking is at head
        if (head.data.equals(booking)) {

            return head.next;
        }

        // Case 3: Booking is in middle or end
        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data.equals(booking)) {

                temp.next = temp.next.next;

                return head;
            }

            temp = temp.next;
        }

        // Case 4: Booking not found
        System.out.println(booking + " not found");

        return head;
    }

    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data + " -> ");

            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        String[] bookings = new String[n];

        System.out.println("Enter booking numbers:");

        for (int i = 0; i < n; i++) {
            bookings[i] = sc.next();
        }

        System.out.print("Enter booking to cancel: ");
        String cancel = sc.next();

        Node head = buildList(bookings);

        head = removeFirst(head, cancel);

        System.out.println("Updated Bookings:");

        printList(head);

        sc.close();
    }
}
