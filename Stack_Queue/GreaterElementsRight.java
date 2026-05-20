import java.util.*;

public class GreaterElementsRight {

    static class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public static int[] countGreater(int[] arr, int[] indices) {

        int n = arr.length;

        // Coordinate Compression
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        Fenwick bit = new Fenwick(rank);

        int[] rightCount = new int[n];

        // Traverse from right
        for (int i = n - 1; i >= 0; i--) {
            int r = map.get(arr[i]);

            // count greater = total - <= current
            rightCount[i] = bit.query(rank) - bit.query(r);

            bit.update(r, 1);
        }

        // Answer queries
        int[] ans = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            ans[i] = rightCount[indices[i]];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};

        System.out.println(Arrays.toString(countGreater(arr, indices)));
        // [6, 1]
    }
}