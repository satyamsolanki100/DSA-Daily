public class ReverseWordsInString {

    public String reverseWords(String s) {
        // Trim leading & trailing spaces
        s = s.trim();

        String[] words = s.split("\\s+"); // split by multiple spaces

        StringBuilder result = new StringBuilder();

        // Traverse from end
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInString obj = new ReverseWordsInString();

        System.out.println(obj.reverseWords("the sky is blue")); 
        // "blue is sky the"

        System.out.println(obj.reverseWords("  hello world  ")); 
        // "world hello"

        System.out.println(obj.reverseWords("a good   example")); 
        // "example good a"
    }
}