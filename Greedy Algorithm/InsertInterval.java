// File: InsertInterval.java

import java.util.*;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};

        int[][] res1 = insert(intervals1, newInterval1);
        for (int[] arr : res1) {
            System.out.print("[" + arr[0] + "," + arr[1] + "] ");
        }
        // Output: [1,5] [6,9]

        System.out.println();

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval2 = {4,8};

        int[][] res2 = insert(intervals2, newInterval2);
        for (int[] arr : res2) {
            System.out.print("[" + arr[0] + "," + arr[1] + "] ");
        }
        // Output: [1,2] [3,10] [12,16]
    }
}