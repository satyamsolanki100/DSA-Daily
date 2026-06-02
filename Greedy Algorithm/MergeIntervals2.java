// File: MergeIntervals.java

import java.util.*;

public class MergeIntervals2 {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] =
                        Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res1 = merge(intervals1);

        for (int[] arr : res1) {
            System.out.print("[" + arr[0] + "," + arr[1] + "] ");
        }
        // Output: [1,6] [8,10] [15,18]

        System.out.println();

        int[][] intervals2 = {{1,4},{4,5}};
        int[][] res2 = merge(intervals2);

        for (int[] arr : res2) {
            System.out.print("[" + arr[0] + "," + arr[1] + "] ");
        }
        // Output: [1,5]
    }
}