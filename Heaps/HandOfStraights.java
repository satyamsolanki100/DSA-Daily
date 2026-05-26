// File: HandOfStraights.java

import java.util.*;

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {

            int first = map.firstKey();

            for (int i = 0; i < groupSize; i++) {

                int curr = first + i;

                if (!map.containsKey(curr)) return false;

                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) == 0) {
                    map.remove(curr);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] hand1 = {1,2,3,6,2,3,4,7,8};
        System.out.println(isNStraightHand(hand1, 3)); // true

        int[] hand2 = {1,2,3,4,5};
        System.out.println(isNStraightHand(hand2, 4)); // false
    }
}