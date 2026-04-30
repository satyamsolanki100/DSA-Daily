import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Check mapping s -> t
            if (mapST.containsKey(ch1)) {
                if (mapST.get(ch1) != ch2) return false;
            } else {
                mapST.put(ch1, ch2);
            }

            // Check reverse mapping t -> s (important)
            if (mapTS.containsKey(ch2)) {
                if (mapTS.get(ch2) != ch1) return false;
            } else {
                mapTS.put(ch2, ch1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();

        System.out.println(obj.isIsomorphic("egg", "add"));   
        // true

        System.out.println(obj.isIsomorphic("f11", "b23"));   
        // false

        System.out.println(obj.isIsomorphic("paper", "title")); 
        // true
    }
}