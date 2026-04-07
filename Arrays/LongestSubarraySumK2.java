// package Arrays;

import java.util.HashMap;

public class LongestSubarraySumK2 {

    // Problem: Longest subarray with sum = K
    // Platform: TUF

    // ----------- Optimal (works for positives + negatives) -----------
    // Approach: Prefix Sum + HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }


    // ----------- Better (ONLY for positive numbers) -----------
    // Approach: Sliding Window
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int longestSubarrayPositive(int[] nums, int k) {

        int left = 0, sum = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        System.out.println(longestSubarray(nums, k)); // works for all cases

        int[] nums2 = {1, 2, 3, 1, 1, 1, 1};
        int k2 = 3;

        System.out.println(longestSubarrayPositive(nums2, k2)); // only positives
    }
}