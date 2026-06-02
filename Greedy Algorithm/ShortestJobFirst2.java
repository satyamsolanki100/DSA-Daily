// File: ShortestJobFirst.java

import java.util.*;

public class ShortestJobFirst2 {

    public static int averageWaitingTime(int[] bt) {

        Arrays.sort(bt);

        int totalWait = 0;
        int currentTime = 0;

        for (int i = 0; i < bt.length; i++) {
            totalWait += currentTime;
            currentTime += bt[i];
        }

        return totalWait / bt.length;
    }

    public static void main(String[] args) {

        int[] bt1 = {4, 1, 3, 7, 2};
        System.out.println(averageWaitingTime(bt1)); // 4

        int[] bt2 = {1, 2, 3, 4};
        System.out.println(averageWaitingTime(bt2)); // 2
    }
}