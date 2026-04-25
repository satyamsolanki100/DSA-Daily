public class MaximumNestingDepth {

    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } 
            else if (ch == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaximumNestingDepth obj = new MaximumNestingDepth();

        System.out.println(obj.maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(obj.maxDepth("(1)+((2))+(((3)))"));   // 3
        System.out.println(obj.maxDepth("()(())((()()))"));      // 3
    }
}