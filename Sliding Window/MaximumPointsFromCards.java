// File: MaximumPointsFromCards.java

public class MaximumPointsFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int total = 0;

        for (int x : cardPoints) total += x;

        if (k == n) return total;

        int windowSize = n - k;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, windowSum);
        }

        return total - minSum;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,1};
        System.out.println(maxScore(arr1, 3)); // 12

        int[] arr2 = {2,2,2};
        System.out.println(maxScore(arr2, 2)); // 4

        int[] arr3 = {9,7,7,9,7,7,9};
        System.out.println(maxScore(arr3, 7)); // 55
    }
}