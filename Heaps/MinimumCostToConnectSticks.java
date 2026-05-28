// File: MinimumCostToConnectSticks.java

import java.util.*;

public class MinimumCostToConnectSticks {

    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int s : sticks) {
            minHeap.offer(s);
        }

        int totalCost = 0;

        while (minHeap.size() > 1) {

            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            minHeap.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        int[] sticks1 = {2, 4, 3};
        System.out.println(connectSticks(sticks1)); // 14

        int[] sticks2 = {1, 8, 3, 5};
        System.out.println(connectSticks(sticks2)); // 30
    }
}