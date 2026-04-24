public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // take first string as base

        for (int i = 1; i < strs.length; i++) {
            // shrink prefix until it matches start of current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[] arr1 = {"flower", "flow", "flight"};
        System.out.println(obj.longestCommonPrefix(arr1)); // "fl"

        String[] arr2 = {"dog", "racecar", "car"};
        System.out.println(obj.longestCommonPrefix(arr2)); // ""
    }
}