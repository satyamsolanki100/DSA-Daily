public class KokoEatingBananas2 {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, h, mid)) {
                ans = mid;
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // ceil division
            if (hours > h) return false;
        }

        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }

    public static void main(String[] args) {
        KokoEatingBananas obj = new KokoEatingBananas();

        int[] piles1 = {3, 6, 7, 11};
        System.out.println(obj.minEatingSpeed(piles1, 8)); // 4

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(obj.minEatingSpeed(piles2, 5)); // 30

        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println(obj.minEatingSpeed(piles3, 6)); // 23
    }
}