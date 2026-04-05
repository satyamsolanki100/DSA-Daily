// package Sorting;

public class BubbleSort {

    // Problem: Sort array using Bubble Sort
    // Platform: TUF
    // Approach: Repeatedly swap adjacent elements if they are in wrong order
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    public static int[] bubbleSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {

                    // swap
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped) break;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        int[] result = bubbleSort(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}