// Problem: Divisors of a Number
// Platform: TUF
// Approach: Iterate till sqrt(n) and collect divisors
// Time Complexity: O(sqrt(n) + k log k)
// Space Complexity: O(k)

import java.util.*;

public class Divisors {

    public static int[] divisors(int n) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }

        Collections.sort(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 36;
        int[] res = divisors(n);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}