import java.util.*;

public class CheckIthBitSet {

    public static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {

        int n1 = 5, i1 = 0;
        System.out.println("Result: " + isBitSet(n1, i1)); // true

        int n2 = 10, i2 = 1;
        System.out.println("Result: " + isBitSet(n2, i2)); // true
    }
}