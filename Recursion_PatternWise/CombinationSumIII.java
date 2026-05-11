import java.util.*;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int target,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // ✅ Valid combination
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // ❌ Invalid cases
        if (current.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {

            current.add(i);

            // move forward → no reuse
            backtrack(i + 1, k, target - i, current, result);

            // backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();

        System.out.println(obj.combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(obj.combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]
    }
}