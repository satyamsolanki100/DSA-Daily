import java.util.*;

public class SwapTwoNumbers {

    // Method 1: Using Arithmetic
    public static void swapArithmetic(int a, int b) {
        System.out.println("Before Swap (Arithmetic): a = " + a + ", b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After Swap (Arithmetic):  a = " + a + ", b = " + b);
    }

    // Method 2: Using XOR
    public static void swapXOR(int a, int b) {
        System.out.println("Before Swap (XOR): a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After Swap (XOR):  a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {

        int a1 = 5, b1 = 10;
        swapArithmetic(a1, b1);

        System.out.println();

        int a2 = -100, b2 = -200;
        swapXOR(a2, b2);
    }
}