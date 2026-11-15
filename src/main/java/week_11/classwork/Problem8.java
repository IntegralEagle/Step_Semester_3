import java.util.ArrayList;

public class Problem8 {

    static ArrayList<Integer> spiralOrder(int[][] grid) {

        ArrayList<Integer> result = new ArrayList<>();

        if (grid.length == 0) {
            return result;
        }

        int top = 0;
        int bottom = grid.length - 1;

        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left to Right
            for (int i = left; i <= right; i++) {
                result.add(grid[top][i]);
            }

            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(grid[i][right]);
            }

            right--;

            // Right to Left
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    result.add(grid[bottom][i]);
                }

                bottom--;
            }

            // Bottom to Top
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    result.add(grid[i][left]);
                }

                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(spiralOrder(grid));
    }
}