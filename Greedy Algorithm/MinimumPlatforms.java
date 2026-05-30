// File: MinimumPlatforms.java

import java.util.*;

public class MinimumPlatforms {

    public static int findPlatform(int[] arr, int[] dep) {

        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {

        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr1, dep1)); // 3

        int[] arr2 = {900, 1100, 1235};
        int[] dep2 = {1000, 1200, 1240};
        System.out.println(findPlatform(arr2, dep2)); // 1
    }
}