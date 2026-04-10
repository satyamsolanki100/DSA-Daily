// package Arrays;

public class RearrangeBySign {

    // Problem: Rearrange array elements by sign
    // Platform: LeetCode
    // Conditions:
    // 1. Equal number of positive & negative
    // 2. Alternate signs
    // 3. Start with positive
    // 4. Maintain order
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    public static int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int posIndex = 0; // even index
        int negIndex = 1; // odd index

        for (int num : nums) {

            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] result = rearrangeArray(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}