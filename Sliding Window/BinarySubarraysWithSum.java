// File: BinarySubarraysWithSum.java

public class BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums1, 2)); // 4

        int[] nums2 = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums2, 0)); // 15
    }
}