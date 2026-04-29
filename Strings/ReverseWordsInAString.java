public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+"); // remove extra spaces
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString obj = new ReverseWordsInAString();

        System.out.println(obj.reverseWords("the sky is blue")); 
        // Output: blue is sky the

        System.out.println(obj.reverseWords("  hello world  ")); 
        // Output: world hello

        System.out.println(obj.reverseWords("a good   example")); 
        // Output: example good a
    }
}