import java.util.*;

public class countSetBits {

    // Function to count set bits using Brian Kernighan’s Algorithm
    public static int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            n = n & (n - 1); // removes lowest set bit
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        // Test cases
        int n1 = 5;
        int n2 = 15;

        System.out.println("Set bits in " + n1 + " = " + countSetBits(n1));
        System.out.println("Set bits in " + n2 + " = " + countSetBits(n2));
    }
}