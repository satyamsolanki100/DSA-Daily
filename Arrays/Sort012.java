// package Arrays;

public class Sort012 {

    // Problem: Sort array of 0s, 1s and 2s
    // Platform: TUF
    // Approach: Dutch National Flag Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static void sort012(int[] nums) {

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

        int[] nums = {1, 0, 2, 1, 0};

        sort012(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}