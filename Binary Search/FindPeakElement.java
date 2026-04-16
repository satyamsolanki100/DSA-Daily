public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is smaller than next → peak is on right
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            else {
                // Peak is on left (including mid)
                right = mid;
            }
        }

        return left; // or right
    }

    // Main method
    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(obj.findPeakElement(nums1)); // 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(obj.findPeakElement(nums2)); // 1 or 5
    }
}