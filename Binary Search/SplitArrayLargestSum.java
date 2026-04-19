public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int low = getMax(nums);   // max element
        int high = getSum(nums);  // total sum
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1; // try smaller largest sum
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > maxSum) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count <= k;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum obj = new SplitArrayLargestSum();

        int[] nums1 = {7, 2, 5, 10, 8};
        System.out.println(obj.splitArray(nums1, 2)); // 18

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(obj.splitArray(nums2, 2)); // 9
    }
}