// package Sorting;

public class QuickSort {

    // Problem: Sort array using Quick Sort
    // Platform: TUF
    // Approach: Pick a pivot, partition array, recursively sort left and right parts
    // Time Complexity: O(n log n) average, O(n^2) worst
    // Space Complexity: O(log n) (recursion stack)

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(nums, low, high);

            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {

        int pivot = nums[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (nums[j] < pivot) {
                i++;

                // swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}