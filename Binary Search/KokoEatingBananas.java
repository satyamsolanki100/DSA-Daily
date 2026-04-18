public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid; // try smaller speed
            } else {
                left = mid + 1; // need more speed
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int totalHours = 0;

        for (int pile : piles) {
            // ceil(pile / k)
            totalHours += (pile + k - 1) / k;
        }

        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();

        int[] piles1 = {3, 6, 7, 11};
        System.out.println(obj.minEatingSpeed(piles1, 8)); // 4

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(obj.minEatingSpeed(piles2, 5)); // 30

        System.out.println(obj.minEatingSpeed(piles2, 6)); // 23
    }
}