
// package Sorting;

public class RecursiveInsertionSort {

    // Problem: Sort array using Recursive Insertion Sort
    // Platform: TUF
    // Approach: Recursively sort first n-1 elements, then insert nth element in correct position
    // Time Complexity: O(n^2)
    // Space Complexity: O(n) (recursion stack)

    public static void insertionSort(int[] nums, int n) {

        // base case
        if (n <= 1) return;

        // sort first n-1 elements
        insertionSort(nums, n - 1);

        // insert last element at correct position
        int last = nums[n - 1];
        insert(nums, n - 2, last);
    }

    // helper function to insert element in sorted part
    public static void insert(int[] nums, int j, int key) {

        // base case
        if (j < 0 || nums[j] <= key) {
            nums[j + 1] = key;
            return;
        }

        nums[j + 1] = nums[j];

        insert(nums, j - 1, key);
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        insertionSort(nums, nums.length);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}