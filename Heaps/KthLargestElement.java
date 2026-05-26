// File: KthLargestElement.java

import java.util.*;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(findKthLargest(nums1, 2)); // 4

        int[] nums2 = {-5, 4, 1, 2, -3};
        System.out.println(findKthLargest(nums2, 5)); // -5
    }
}