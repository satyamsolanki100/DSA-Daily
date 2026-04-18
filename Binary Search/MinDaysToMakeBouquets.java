public class MinDaysToMakeBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // Not enough flowers
        if ((long) m * k > n) return -1;

        int left = getMin(bloomDay);
        int right = getMax(bloomDay);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid; // try smaller days
            } else {
                left = mid + 1; // need more days
            }
        }

        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int count = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; // reset for next bouquet
                }
            } else {
                count = 0; // break adjacency
            }
        }

        return bouquets >= m;
    }

    private int getMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) min = Math.min(min, num);
        return min;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) max = Math.max(max, num);
        return max;
    }

    // Main method
    public static void main(String[] args) {
        MinDaysToMakeBouquets obj = new MinDaysToMakeBouquets();

        int[] bloom1 = {1, 10, 3, 10, 2};
        System.out.println(obj.minDays(bloom1, 3, 1)); // 3

        int[] bloom2 = {1, 10, 3, 10, 2};
        System.out.println(obj.minDays(bloom2, 3, 2)); // -1

        int[] bloom3 = {7, 7, 7, 7, 12, 7, 7};
        System.out.println(obj.minDays(bloom3, 2, 3)); // 12
    }
}