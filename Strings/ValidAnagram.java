public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        // If lengths differ → cannot be anagram
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // for lowercase letters

        // Count characters in s
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Subtract using t
        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;

            // If any count becomes negative → mismatch
            if (count[ch - 'a'] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();

        System.out.println(obj.isAnagram("anagram", "nagaram")); 
        // true

        System.out.println(obj.isAnagram("rat", "car")); 
        // false
    }
}