// File: CountNumberOfNiceSubarrays.java

public class CountNumberOfNiceSubarrays2 {

    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 == 1) k--;

            while (k < 0) {
                if (nums[left] % 2 == 1) k++;
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums1, 3)); // 2

        int[] nums2 = {2,4,6};
        System.out.println(numberOfSubarrays(nums2, 1)); // 0

        int[] nums3 = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(numberOfSubarrays(nums3, 2)); // 16
    }
}