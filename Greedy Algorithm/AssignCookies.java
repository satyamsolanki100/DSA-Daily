// File: AssignCookies.java

import java.util.*;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }

        return i;
    }

    public static void main(String[] args) {

        int[] g1 = {1,2,3};
        int[] s1 = {1,1};
        System.out.println(findContentChildren(g1, s1)); // 1

        int[] g2 = {1,2};
        int[] s2 = {1,2,3};
        System.out.println(findContentChildren(g2, s2)); // 2
    }
}