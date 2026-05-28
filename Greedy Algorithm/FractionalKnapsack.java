// File: FractionalKnapsack.java

import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static double maximumValue(int[] val, int[] wt, int capacity) {

        int n = val.length;
        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) -> 
            Double.compare((double)b.value / b.weight, (double)a.value / a.weight)
        );

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += ((double)item.value / item.weight) * capacity;
                break;
            }
        }

        return Math.round(totalValue * 1e6) / 1e6;
    }

    public static void main(String[] args) {

        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        System.out.printf("%.6f\n", maximumValue(val1, wt1, 50)); // 240.000000

        int[] val2 = {60, 100};
        int[] wt2 = {10, 20};
        System.out.printf("%.6f\n", maximumValue(val2, wt2, 50)); // 160.000000
    }
}