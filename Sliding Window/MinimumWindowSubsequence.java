// File: MinimumWindowSubsequence.java

public class MinimumWindowSubsequence {

    public static String minWindow(String s1, String s2) {

        int n = s1.length(), m = s2.length();
        int minLen = Integer.MAX_VALUE, start = -1;

        for (int i = 0; i < n; i++) {

            if (s1.charAt(i) == s2.charAt(0)) {

                int j = i, k = 0;

                // forward match
                while (j < n && k < m) {
                    if (s1.charAt(j) == s2.charAt(k)) k++;
                    j++;
                }

                if (k == m) {
                    int end = j - 1;
                    k = m - 1;

                    // backward shrink
                    while (j >= i) {
                        if (s1.charAt(j - 1) == s2.charAt(k)) {
                            k--;
                            if (k < 0) break;
                        }
                        j--;
                    }

                    int windowLen = end - j + 1;

                    if (windowLen < minLen) {
                        minLen = windowLen;
                        start = j;
                    }
                }
            }
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }

    public static void main(String[] args) {

        System.out.println(minWindow("abcdebdde", "bde")); // bcde
        System.out.println(minWindow("jmeqsiwvaovvnbstl", "u")); // ""
    }
}