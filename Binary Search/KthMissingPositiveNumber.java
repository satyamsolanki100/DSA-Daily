public class KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        // Binary Search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // missing numbers till index mid
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // kth missing number
        return low + k;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber obj = new KthMissingPositiveNumber();

        int[] arr1 = {2, 3, 4, 7, 11};
        System.out.println(obj.findKthPositive(arr1, 5)); // 9

        int[] arr2 = {1, 2, 3, 4};
        System.out.println(obj.findKthPositive(arr2, 2)); // 6
    }
}