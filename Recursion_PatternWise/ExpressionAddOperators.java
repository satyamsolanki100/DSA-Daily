import java.util.*;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target,
                           int index, long calc, long prev, String path) {

        // Base case
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // ❌ Skip leading zero
            if (i != index && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                // First number (no operator)
                backtrack(result, num, target, i + 1, curr, curr, path + curr);
            } else {

                // +
                backtrack(result, num, target, i + 1,
                        calc + curr, curr, path + "+" + curr);

                // -
                backtrack(result, num, target, i + 1,
                        calc - curr, -curr, path + "-" + curr);

                // *
                backtrack(result, num, target, i + 1,
                        calc - prev + (prev * curr),
                        prev * curr,
                        path + "*" + curr);
            }
        }
    }

    public static void main(String[] args) {

        ExpressionAddOperators obj = new ExpressionAddOperators();

        System.out.println(obj.addOperators("123", 6));
        // ["1+2+3", "1*2*3"]
    }
}