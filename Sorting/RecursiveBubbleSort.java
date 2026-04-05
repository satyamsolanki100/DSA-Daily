// package Sorting;

public class RecursiveBubbleSort {

    // Problem: Sort array using Recursive Bubble Sort
    // Platform: TUF
    // Approach: Recursively place the largest element at the end in each pass
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) (due to recursion stack)

    public static void bubbleSort(int[] nums, int n) {

        // base case
        if (n == 1) return;

        // one pass: push largest to end
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }

        // recursive call for remaining array
        bubbleSort(nums, n - 1);
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        bubbleSort(nums, nums.length);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}