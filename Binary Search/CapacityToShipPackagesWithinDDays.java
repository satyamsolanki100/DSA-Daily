class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);      // minimum capacity
        int high = getSum(weights);     // maximum capacity
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // try smaller capacity
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }

        return daysNeeded <= days;
    }

    private int getMax(int[] weights) {
        int max = weights[0];
        for (int w : weights) {
            if (w > max) max = w;
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }
}