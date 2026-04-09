// package Arrays;

public class MajorityElementI {

    // Problem: Majority Element (> n/2 times)
    // Platform: TUF
    // Approach: Boyer-Moore Voting Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        int result = majorityElement(nums);

        System.out.println(result);
    }
}