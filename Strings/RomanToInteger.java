import java.util.*;

public class RomanToInteger {

    public int romanToInt(String s) {
        // Step 1: Map values
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        // Step 2: Traverse string
        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            // Check next value
            if (i + 1 < s.length() && current < map.get(s.charAt(i + 1))) {
                total -= current; // subtract case
            } else {
                total += current; // normal add
            }
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();

        System.out.println(obj.romanToInt("III"));      // 3
        System.out.println(obj.romanToInt("LVIII"));    // 58
        System.out.println(obj.romanToInt("MCMXCIV"));  // 1994
    }
}