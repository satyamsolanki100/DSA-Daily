
public class MissingNumber {
    public static int findMissing(int[] nums) {
        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 1, 4};
        System.out.println(findMissing(nums)); // Output: 5
    }
}