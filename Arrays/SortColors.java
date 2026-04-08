// package Arrays;

public class SortColors {

    // Problem: Sort Colors (0s, 1s, 2s)
    // Platform: LeetCode
    // Approach: Dutch National Flag Algorithm (3 pointers)
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else { // nums[mid] == 2

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}