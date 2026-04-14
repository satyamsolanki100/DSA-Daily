public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids overflow

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();

        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(obj.search(nums, 9)); // Output: 4
        System.out.println(obj.search(nums, 2)); // Output: -1
    }
}