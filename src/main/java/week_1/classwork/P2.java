import java.util.Scanner;

public class P2 {

    // 1. Iterative approach
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // 2. Recursive approach
    static boolean isPalindromeRecursive(String text) {

        return checkRecursive(text, 0, text.length() - 1);
    }

    static boolean checkRecursive(String text, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // Characters don't match
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        // Move towards the middle
        return checkRecursive(text, left + 1, right - 1);
    }


    // 3. Array reversal approach
    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println();

        System.out.println("Iterative: " +
                (iterative ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursive ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayReversal ? "Palindrome" : "Not Palindrome"));

        sc.close();
    }
}