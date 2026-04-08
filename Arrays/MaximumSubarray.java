// package Arrays;

public class MaximumSubarray {

    // Problem: Maximum Subarray Sum
    // Platform: LeetCode
    // Approach: Kadane’s Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(nums);

        System.out.println(result);
    }
}