public class FirstLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);
        return new int[]{first, last};
    }

    private int firstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // move left
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int lastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // move right
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Main method
    public static void main(String[] args) {
        FirstLastPosition obj = new FirstLastPosition();

        int[] nums = {5, 7, 7, 8, 8, 10};

        int[] res1 = obj.searchRange(nums, 8);
        System.out.println("[" + res1[0] + "," + res1[1] + "]"); // [3,4]

        int[] res2 = obj.searchRange(nums, 6);
        System.out.println("[" + res2[0] + "," + res2[1] + "]"); // [-1,-1]

        int[] nums2 = {};
        int[] res3 = obj.searchRange(nums2, 0);
        System.out.println("[" + res3[0] + "," + res3[1] + "]"); // [-1,-1]
    }
}