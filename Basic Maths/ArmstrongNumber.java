// package Basic Maths;

public class ArmstrongNumber {
  // Problem: Check if Number is Armstrong
// Platform: TUF
// Approach: Count digits and compute sum of powers
// Time Complexity: O(d)
// Space Complexity: O(1)



    public static boolean isArmstrong(int n) {

        int copy = n;
        int digits = 0;

        int temp = n;
        while (temp != 0) {
            temp = temp / 10;
            digits++;
        }

        int sum = 0;
        temp = n;

        while (temp != 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, digits);
            temp = temp / 10;
        }

        return copy == sum;
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println(isArmstrong(n));
    }
}

