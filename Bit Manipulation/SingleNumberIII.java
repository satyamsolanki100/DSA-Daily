import java.util.*;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        int xor = 0;

        // Step 1: XOR all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Get rightmost set bit
        int diffBit = xor & (-xor);

        int x = 0, y = 0;

        // Step 3: Divide into 2 groups
        for (int num : nums) {
            if ((num & diffBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Step 4: Sort result
        if (x < y) return new int[]{x, y};
        else return new int[]{y, x};
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 1, 3, 5, 2};
        System.out.println(Arrays.toString(singleNumber(nums1)));

        int[] nums2 = {-1, 0};
        System.out.println(Arrays.toString(singleNumber(nums2)));
    }
}