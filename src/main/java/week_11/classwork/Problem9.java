public class Problem9 {

    static int[] pairSumSorted(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {

                return new int[]{
                    nums[left],
                    nums[right]
                };
            }

            else if (sum < target) {

                left++;
            }

            else {

                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums1 = {-4, -1, 0, 3, 5, 9};

        int[] nums2 = {1, 2, 3};

        int[] result1 = pairSumSorted(nums1, 4);

        int[] result2 = pairSumSorted(nums2, 100);

        if (result1[0] == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(
                "(" + result1[0] + ", " + result1[1] + ")"
            );
        }

        if (result2[0] == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println(
                "(" + result2[0] + ", " + result2[1] + ")"
            );
        }
    }
}