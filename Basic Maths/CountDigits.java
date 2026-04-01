// package Basic Maths;

 // Problem: Count Digits of a Number
// Platform: TUF / Basic Math
// Approach: Iterative Division

import java.util.*;

public class CountDigits{

    public static int countDigits(int n) {
        int count = 0;

       
        if (n == 0) return 1;

        while (n > 0) {
            n = n / 10; 
            count++;     
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Number of digits: " + countDigits(n));
    }
} 
  

