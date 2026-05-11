import java.util.*;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 🔥 important

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            // 🔥 Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);

            backtrack(i + 1, nums, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII obj = new SubsetsII();

        int[] nums = {1, 2, 2};
        System.out.println(obj.subsetsWithDup(nums));
    }
}