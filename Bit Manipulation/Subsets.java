import java.util.*;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);

            // Recurse
            backtrack(i + 1, nums, current, result);

            // Backtrack (remove)
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets: " + subsets(nums1));

        int[] nums2 = {0};
        System.out.println("Subsets: " + subsets(nums2));
    }
}