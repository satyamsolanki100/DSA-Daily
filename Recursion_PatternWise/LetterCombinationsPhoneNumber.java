import java.util.*;

public class LetterCombinationsPhoneNumber {

    private static final String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits,
                           StringBuilder current,
                           List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            current.append(ch);

            backtrack(index + 1, digits, current, result);

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();

        System.out.println(obj.letterCombinations("23"));
    }
}