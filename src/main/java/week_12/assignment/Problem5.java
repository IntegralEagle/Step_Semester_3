
import java.util.Scanner;

public class Problem5 {

    static class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    static int size = 0;

    // Push operation
    static void push(String plate) {

        Node newNode = new Node(plate);

        newNode.next = top;

        top = newNode;

        size++;

        System.out.println("push " + plate
                + " -> top " + plate
                + ", size " + size);
    }

    // Pop operation
    static void pop() {

        if (isEmpty()) {

            System.out.println("pop -> stack is empty");

            return;
        }

        String removed = top.data;

        top = top.next;

        size--;

        System.out.println("pop -> " + removed
                + ", size " + size);
    }

    // Peek operation
    static void peek() {

        if (isEmpty()) {

            System.out.println("peek -> stack is empty");
        }
        else {

            System.out.println("peek -> " + top.data);
        }
    }

    // Check empty
    static boolean isEmpty() {

        return top == null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of operations: ");

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String operation = sc.next();

            switch (operation) {

                case "push":

                    String plate = sc.next();

                    push(plate);

                    break;

                case "pop":

                    pop();

                    break;

                case "peek":

                    peek();

                    break;

                case "isEmpty":

                    System.out.println("isEmpty -> " + isEmpty());

                    break;

                default:

                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
