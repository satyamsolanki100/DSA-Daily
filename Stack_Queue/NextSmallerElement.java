import java.util.*;

public class NextSmallerElement {

    public static int[] nextSmaller(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmaller(arr1))); 
        // [2, 5, 2, -1, -1]

        int[] arr2 = {10, 9, 8, 7};
        System.out.println(Arrays.toString(nextSmaller(arr2))); 
        // [9, 8, 7, -1]
    }
}