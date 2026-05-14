public class CheckIthBit {

    public static boolean isSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {

        System.out.println(isSet(5, 0));  // true
        System.out.println(isSet(10, 1)); // true
        System.out.println(isSet(10, 2)); // false
    }
}