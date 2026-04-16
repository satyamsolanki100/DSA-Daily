public class FindMinimumRotatedArray {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right → min is in right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            else {
                // Min is in left half (including mid)
                right = mid;
            }
        }

        return nums[left]; // or nums[right]
    }

    // Main method
    public static void main(String[] args) {
        FindMinimumRotatedArray obj = new FindMinimumRotatedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(obj.findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(obj.findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(obj.findMin(nums3)); // 11
    }
}