public class ReverseWords {

    public String reverseWords(String s) {
        // Step 1: trim spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        // Step 2: reverse order of words
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) result.append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();

        System.out.println(obj.reverseWords("welcome to the jungle"));
        // jungle the to welcome

        System.out.println(obj.reverseWords(" amazing coding skills "));
        // skills coding amazing
    }
}