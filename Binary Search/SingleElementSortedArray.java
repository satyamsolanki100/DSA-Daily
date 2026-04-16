public class SingleElementSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Make mid even (important trick)
            if (mid % 2 == 1) {
                mid--;
            }

            // Check pair
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2; // move right
            } else {
                right = mid; // move left
            }
        }

        return nums[left];
    }

    // Main method
    public static void main(String[] args) {
        SingleElementSortedArray obj = new SingleElementSortedArray();

        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(obj.singleNonDuplicate(nums1)); // 2

        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(obj.singleNonDuplicate(nums2)); // 10
    }
}