import java.util.*;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse twice
        for (int i = 0; i < 2 * n; i++) {

            int idx = i % n;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                ans[stack.pop()] = nums[idx];
            }

            // Only push indices in first pass
            if (i < n) {
                stack.push(idx);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums1))); // [2, -1, 2]

        int[] nums2 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums2))); // [2,3,4,-1,4]
    }
}