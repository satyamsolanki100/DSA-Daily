// File: NonOverlappingIntervals.java

import java.util.*;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {
                // Overlap → remove
                count++;
            } else {
                // No overlap → update end
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals1)); // 1

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println(eraseOverlapIntervals(intervals2)); // 2

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println(eraseOverlapIntervals(intervals3)); // 0
    }
}