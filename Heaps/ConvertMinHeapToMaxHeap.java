// File: ConvertMinHeapToMaxHeap.java

public class ConvertMinHeapToMaxHeap {

    public static void convert(int[] nums) {
        int n = nums.length;

        // Build max heap using heapify
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 20, 30, 21, 23};
        convert(nums1);

        for (int x : nums1) System.out.print(x + " ");
        System.out.println();

        int[] nums2 = {-5, -4, -3, -2, -1};
        convert(nums2);

        for (int x : nums2) System.out.print(x + " ");
    }
}