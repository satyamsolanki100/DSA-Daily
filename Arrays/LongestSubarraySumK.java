// package Arrays;

import java.util.HashMap;

public class LongestSubarraySumK {

    // Problem: Longest subarray with sum = K
    // Platform: TUF
    // Approach: Prefix Sum + HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // case 1: if sum == k
            if (sum == k) {
                maxLen = i + 1;
            }

            // case 2: check if (sum - k) exists
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // store first occurrence of sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int result = longestSubarray(nums, k);

        System.out.println(result);
    }
}