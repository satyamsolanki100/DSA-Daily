import java.util.*;

public class SumSubarrayRanges {

    public static long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    // Sum of subarray minimums
    private static long sumMin(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= (i < n ? arr[i] : 0))) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                res += count * arr[mid];
            }
            stack.push(i);
        }
        return res;
    }

    // Sum of subarray maximums
    private static long sumMax(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long res = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] <= (i < n ? arr[i] : 0))) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (long)(mid - left) * (right - mid);
                res += count * arr[mid];
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3};
        System.out.println(subArrayRanges(nums1)); // 4

        int[] nums2 = {1,3,3};
        System.out.println(subArrayRanges(nums2)); // 4

        int[] nums3 = {4,-2,-3,4,1};
        System.out.println(subArrayRanges(nums3)); // 59
    }
}