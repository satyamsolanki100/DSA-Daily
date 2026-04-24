public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    result.append(ch); // not outer
                }
                count++;
            } else { // ')'
                count--;
                if (count > 0) {
                    result.append(ch); // not outer
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();

        System.out.println(obj.removeOuterParentheses("(()())(())")); 
        // "()()()"

        System.out.println(obj.removeOuterParentheses("(()())(())(()(()))")); 
        // "()()()()(())"

        System.out.println(obj.removeOuterParentheses("()()")); 
        // ""
    }
}