import java.util.*;

public class CheckOddOrEven {

    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static void main(String[] args) {

        int n1 = 7;
        System.out.println("Is Odd: " + isOdd(n1)); // true

        int n2 = 0;
        System.out.println("Is Odd: " + isOdd(n2)); // false
    }
}