// File: ReplaceElementsByRank.java

import java.util.*;

public class ReplaceElementsByRank {

    public static int[] replaceWithRank(int[] arr) {

        int n = arr.length;

        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : temp) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {20, 15, 26, 2, 98, 6};
        System.out.println(Arrays.toString(replaceWithRank(arr1))); // [4,3,5,1,6,2]

        int[] arr2 = {1, 5, 8, 15, 8, 25, 9};
        System.out.println(Arrays.toString(replaceWithRank(arr2))); // [1,2,3,5,3,6,4]
    }
}