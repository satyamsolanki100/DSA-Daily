// package Arrays;

public class NextPermutation {

    // Problem: Next Permutation
    // Platform: LeetCode
    // Approach:
    // 1. Find breakpoint (first decreasing from right)
    // 2. Swap with next greater element on right
    // 3. Reverse the suffix
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;

        // Step 1: find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: if breakpoint exists, swap
        if (index != -1) {
            for (int i = n - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
        }

        // Step 3: reverse suffix
        reverse(nums, index + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}