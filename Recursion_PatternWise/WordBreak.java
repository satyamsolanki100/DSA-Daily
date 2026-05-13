import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return solve(0, s, set, memo);
    }

    private boolean solve(int index, String s,
                          Set<String> dict, Boolean[] memo) {

        // Reached end
        if (index == s.length()) return true;

        // Already computed
        if (memo[index] != null) return memo[index];

        for (int i = index + 1; i <= s.length(); i++) {

            String prefix = s.substring(index, i);

            if (dict.contains(prefix) && solve(i, s, dict, memo)) {
                return memo[index] = true;
            }
        }

        return memo[index] = false;
    }

    public static void main(String[] args) {

        WordBreak obj = new WordBreak();

        String s = "takeuforward";
        List<String> dict = Arrays.asList("take","forward","you","u");

        System.out.println(obj.wordBreak(s, dict)); // true
    }
}