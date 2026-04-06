// package Arrays;

public class CheckSortedAndRotated {

    // Problem: Check if array is sorted and rotated
    // Platform: LeetCode
    // Approach: Count number of "drops" (nums[i] > nums[i+1])
    // If drops > 1 → false
    // Also check last and first element
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static boolean check(int[] nums) {

        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        boolean result = check(nums);

        System.out.println(result);
    }
}