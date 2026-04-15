public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(obj.search(nums1, 0)); // 4
        System.out.println(obj.search(nums1, 3)); // -1

        int[] nums2 = {1};
        System.out.println(obj.search(nums2, 0)); // -1
    }
}