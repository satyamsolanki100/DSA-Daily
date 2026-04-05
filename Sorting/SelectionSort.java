// package Sorting;

public class SelectionSort {

    // Problem: Sort array using Selection Sort
    // Platform: TUF
    // Approach: Select minimum element and swap with current index
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    public static int[] selectionSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        int[] result = selectionSort(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}