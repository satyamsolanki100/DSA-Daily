import java.util.*;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, String s,
                           List<String> path,
                           List<List<String>> result) {

        // If reached end → valid partition
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                // Choose
                path.add(s.substring(index, i + 1));

                // Explore
                backtrack(i + 1, s, path, result);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning obj = new PalindromePartitioning();

        String s = "aabaa";
        System.out.println(obj.partition(s));
    }
}