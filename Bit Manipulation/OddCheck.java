public class OddCheck {

    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    public static void main(String[] args) {

        System.out.println(isOdd(7)); // true
        System.out.println(isOdd(0)); // false
        System.out.println(isOdd(10)); // false
    }
}