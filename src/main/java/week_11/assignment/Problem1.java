
import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

    static void lineUp(int[] heights) {

        int n = heights.length;
        int pass = 1;

        while (true) {

            boolean swapped = false;

            for (int j = 0; j < n - pass; j++) {

                if (heights[j] > heights[j + 1]) {

                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": "
                    + Arrays.toString(heights));

            if (!swapped) {
                break;
            }

            pass++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter heights:");

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        lineUp(heights);

        sc.close();
    }
}
