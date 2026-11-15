import java.util.HashSet;

public class Problem5 {

    static boolean hasPairWithSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (set.contains(complement)) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};

        int[] nums2 = {3, 4, 6};

        System.out.println(
            hasPairWithSum(nums1, 9)
        );

        System.out.println(
            hasPairWithSum(nums2, 20)
        );
    }
}