

public class InsertionSort {

    // Problem: Sort array using Insertion Sort
    // Platform: TUF
    // Approach: Place each element at its correct position in the sorted part
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)

    public static int[] insertionSort(int[] nums) {

        int n = nums.length;

        for (int i = 1; i < n; i++) {

            int key = nums[i];
            int j = i - 1;

            // shift elements greater than key
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {7, 4, 1, 5, 3};

        int[] result = insertionSort(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}