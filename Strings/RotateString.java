public class RotateString {

    public boolean rotateString(String s, String goal) {
        // Length must be same
        if (s.length() != goal.length()) return false;

        // Trick: concatenate s with itself
        String doubled = s + s;

        // Check if goal is a substring
        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        RotateString obj = new RotateString();

        System.out.println(obj.rotateString("abcde", "cdeab")); // true
        System.out.println(obj.rotateString("abcde", "abced")); // false
    }
}