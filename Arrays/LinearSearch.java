// package Arrays;

public class LinearSearch {

    // Problem: Find first occurrence of target
    // Platform: TUF
    // Approach: Traverse array and compare each element
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i; // first occurrence
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5, 3};
        int target = 3;

        int result = search(nums, target);

        System.out.println(result);
    }
}