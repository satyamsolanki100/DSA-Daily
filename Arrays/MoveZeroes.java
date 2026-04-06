// package Arrays;

public class MoveZeroes {

    // Problem: Move all zeroes to the end (in-place)
    // Platform: LeetCode
    // Approach: Two pointers (place non-zero elements first)
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static void moveZeroes(int[] nums) {

        int i = 0; // position to place next non-zero

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}