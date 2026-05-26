// File: TaskScheduler.java

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int maxCount = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) maxCount++;
            else break;
        }

        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {

        char[] tasks1 = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks1, 2)); // 8

        char[] tasks2 = {'A','C','A','B','D','B'};
        System.out.println(leastInterval(tasks2, 1)); // 6

        char[] tasks3 = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(tasks3, 3)); // 10
    }
}