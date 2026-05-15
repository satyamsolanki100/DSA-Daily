import java.util.*;

public class Subsets2 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // Include element
            current.add(nums[i]);

            // Recurse
            solve(i + 1, nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        System.out.println(subsets(nums1));

        int[] nums2 = {0};
        System.out.println(subsets(nums2));
    }
}