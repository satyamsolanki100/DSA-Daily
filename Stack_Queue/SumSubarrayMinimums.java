import java.util.*;

public class SumSubarrayMinimums {

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long mod = 1_000_000_007;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element (Strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element (Smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            sum = (sum + (arr[i] * left * right) % mod) % mod;
        }

        return (int) sum;
    }

    public static void main(String[] args) {

        int[] arr1 = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr1)); // 17

        int[] arr2 = {11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr2)); // 444
    }
}