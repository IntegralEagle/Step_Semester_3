
import java.util.Scanner;

public class Problem3 {

    static class Node {

        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node buildList(String[] books) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < books.length; i++) {

            Node newNode = new Node(books[i]);

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

    static String find(Node head, String id) {

        Node temp = head;

        int position = 1;
        int copies = 0;
        int firstPosition = -1;

        while (temp != null) {

            if (temp.data.equals(id)) {

                copies++;

                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }

            position++;

            temp = temp.next;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position "
                + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        String[] books = new String[n];

        System.out.println("Enter book IDs:");

        for (int i = 0; i < n; i++) {
            books[i] = sc.next();
        }

        System.out.print("Enter ID to search: ");
        String id = sc.next();

        Node head = buildList(books);

        System.out.println(find(head, id));

        sc.close();
    }
}
