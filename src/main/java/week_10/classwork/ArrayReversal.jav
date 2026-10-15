
import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {

        int[] arr = {11, 22, 33, 44};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
