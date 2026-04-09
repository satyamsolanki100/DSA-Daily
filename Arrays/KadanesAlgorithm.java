// package Arrays;

public class KadanesAlgorithm {

    // Problem: Maximum Subarray Sum (Kadane's Algorithm)
    // Platform: TUF
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int maxSubarraySum(int[] nums) {

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // Optional: Print subarray
    public static void printSubarray(int[] nums) {

        int maxSum = nums[0], currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nMax Sum = " + maxSum);
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, -2, 7, -4};

        System.out.println(maxSubarraySum(nums));

        printSubarray(nums);
    }
}