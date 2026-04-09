// package Arrays;

import java.util.HashMap;

public class TwoSumTUF {

    // Problem: Two Sum (return indices in increasing order)
    // Platform: TUF
    // Approach: HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                int index1 = map.get(complement);
                int index2 = i;

                // return in increasing order
                if (index1 < index2) {
                    return new int[]{index1, index2};
                } else {
                    return new int[]{index2, index1};
                }
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {1, 6, 2, 10, 3};
        int target = 7;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + " " + result[1]);
    }
}