import java.util.*;

public class XorRange {

    // XOR from 1 to n
    public static int xorUptoN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }

    // XOR from L to R
    public static int xorRange(int L, int R) {
        return xorUptoN(R) ^ xorUptoN(L - 1);
    }

    public static void main(String[] args) {

        int L1 = 3, R1 = 5;
        System.out.println("XOR from " + L1 + " to " + R1 + " = " + xorRange(L1, R1));

        int L2 = 1, R2 = 3;
        System.out.println("XOR from " + L2 + " to " + R2 + " = " + xorRange(L2, R2));
    }
}