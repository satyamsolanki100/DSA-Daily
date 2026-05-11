import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 🔥 important

        backtrack(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> current, List<List<Integer>> result) {

        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // 🔥 Skip duplicates
            if (i > index && arr[i] == arr[i - 1]) continue;

            // Stop if exceeded
            if (arr[i] > target) break;

            current.add(arr[i]);

            // Move to next index (no reuse)
            backtrack(i + 1, arr, target - arr[i], current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();

        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(obj.combinationSum2(arr, 8));
    }
}