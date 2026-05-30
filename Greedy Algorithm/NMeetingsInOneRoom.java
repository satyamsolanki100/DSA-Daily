// File: NMeetingsInOneRoom.java

import java.util.*;

class Meeting {
    int start, end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class NMeetingsInOneRoom {

    public static int maxMeetings(int[] start, int[] end) {

        int n = start.length;
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1;
        int lastEnd = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1 = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start1, end1)); // 4

        int[] start2 = {10, 12, 20};
        int[] end2 = {20, 25, 30};
        System.out.println(maxMeetings(start2, end2)); // 1
    }
}