import java.util.*;

public class MinimumBitFlipsToConvertNumber {

    // Function to calculate minimum bit flips
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal; // Step 1: find differing bits
        int count = 0;

        // Step 2: count set bits (Brian Kernighan’s Algorithm)
        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int start1 = 10, goal1 = 7;
        System.out.println("Minimum flips: " + minBitFlips(start1, goal1));

        int start2 = 3, goal2 = 4;
        System.out.println("Minimum flips: " + minBitFlips(start2, goal2));
    }
}