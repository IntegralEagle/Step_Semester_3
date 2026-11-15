
import java.util.Scanner;

public class Problem2 {

    static class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at beginning
    static Node addFirst(Node head, String name) {

        Node newNode = new Node(name);

        newNode.next = head;

        head = newNode;

        return head;
    }

    // Insert at end
    static Node addLast(Node head, String name) {

        Node newNode = new Node(name);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    // Print linked list
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

        Node head = null;

        System.out.print("Enter initial number of students: ");
        int n = sc.nextInt();

        System.out.println("Enter student names:");

        for (int i = 0; i < n; i++) {

            String name = sc.next();

            head = addLast(head, name);
        }

        System.out.print("Enter number of operations: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {

            String operation = sc.next();
            String name = sc.next();

            if (operation.equalsIgnoreCase("addFirst")) {

                head = addFirst(head, name);
            }
            else if (operation.equalsIgnoreCase("addLast")) {

                head = addLast(head, name);
            }
        }

        System.out.println("Final Line:");

        printList(head);

        sc.close();
    }
}
