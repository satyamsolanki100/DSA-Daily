// package Arrays;

public class RemoveDuplicatesSortedArray {

    // Problem: Remove duplicates from sorted array (in-place)
    // Platform: LeetCode
    // Approach: Two pointers
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0; // pointer for unique elements

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // number of unique elements
    }

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println("k = " + k);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}