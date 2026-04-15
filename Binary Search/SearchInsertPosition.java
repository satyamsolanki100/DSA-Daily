public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

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

        // insertion position
        return left;
    }

    // Main method for testing
    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};

        System.out.println(obj.searchInsert(nums, 5)); // 2
        System.out.println(obj.searchInsert(nums, 2)); // 1
        System.out.println(obj.searchInsert(nums, 7)); // 4
    }
}