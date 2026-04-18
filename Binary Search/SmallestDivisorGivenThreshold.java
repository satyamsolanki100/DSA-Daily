class SmallestDivisorGivenThreshold {

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1; // try smaller divisor
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] nums, int threshold, int divisor) {
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
}