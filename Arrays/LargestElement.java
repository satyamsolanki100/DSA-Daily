// package Arrays;

public class LargestElement {

    // Problem: Find the largest element in an array
    // Platform: TUF
    // Approach: Traverse array and keep track of maximum
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int findLargest(int[] nums) {

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {3, 3, 6, 1};

        int result = findLargest(nums);

        System.out.println(result);
    }
}