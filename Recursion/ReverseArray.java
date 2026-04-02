// Problem: Reverse an Array
// Platform: TUF
// Approach: Two Pointer Recursion (swap start & end)
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class ReverseArray {

    public static void reverse(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        reverse(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}