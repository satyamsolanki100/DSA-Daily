// File: MaximumSumCombination.java

import java.util.*;

public class MaximumSumCombination {

    static class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public static List<Integer> maxCombinations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> b.sum - a.sum
        );

        Set<String> visited = new HashSet<>();

        int i = n - 1, j = n - 1;

        maxHeap.offer(new Pair(nums1[i] + nums2[j], i, j));
        visited.add(i + "," + j);

        List<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {

            Pair curr = maxHeap.poll();
            result.add(curr.sum);

            int x = curr.i;
            int y = curr.j;

            if (x - 1 >= 0) {
                String key = (x - 1) + "," + y;
                if (!visited.contains(key)) {
                    maxHeap.offer(new Pair(nums1[x - 1] + nums2[y], x - 1, y));
                    visited.add(key);
                }
            }

            if (y - 1 >= 0) {
                String key = x + "," + (y - 1);
                if (!visited.contains(key)) {
                    maxHeap.offer(new Pair(nums1[x] + nums2[y - 1], x, y - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {7, 3};
        int[] nums2 = {1, 6};

        System.out.println(maxCombinations(nums1, nums2, 2)); // [13, 9]

        int[] nums3 = {3, 4, 5};
        int[] nums4 = {2, 6, 3};

        System.out.println(maxCombinations(nums3, nums4, 2)); // [11, 10]
    }
}