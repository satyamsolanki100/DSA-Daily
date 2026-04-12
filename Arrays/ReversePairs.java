public class ReversePairs {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {

        if (low >= high) return 0;

        int mid = (low + high) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {

            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }

            count += (right - (mid + 1));
        }

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) temp[k++] = nums[left++];
        while (right <= high) temp[k++] = nums[right++];

        // Copy back
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums)); // Output: 2
    }
}