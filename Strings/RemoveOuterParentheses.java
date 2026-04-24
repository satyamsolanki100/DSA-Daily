public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            // if '(' → add only if already inside
            if (ch == '(') {
                if (count > 0) result.append(ch);
                count++;
            } 
            // if ')' → decrease first, then decide
            else {
                count--;
                if (count > 0) result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOuterParentheses obj = new RemoveOuterParentheses();

        System.out.println(obj.removeOuterParentheses("((()))"));        // "(())"
        System.out.println(obj.removeOuterParentheses("()(()())(())"));  // "()()()"
    }
}