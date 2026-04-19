public class FindSmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDivide(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canDivide(int[] nums, int threshold, int divisor) {
        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // ceil division
            if (sum > threshold) return false;
        }

        return true;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        FindSmallestDivisor obj = new FindSmallestDivisor();

        int[] nums1 = {1, 2, 5, 9};
        System.out.println(obj.smallestDivisor(nums1, 6)); // 5

        int[] nums2 = {44, 22, 33, 11, 1};
        System.out.println(obj.smallestDivisor(nums2, 5)); // 44
    }
}