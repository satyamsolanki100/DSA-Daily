// File: SubarraysWithKDifferentIntegers.java

import java.util.*;

public class SubarraysWithKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums1, 2)); // 7

        int[] nums2 = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(nums2, 3)); // 3
    }
}