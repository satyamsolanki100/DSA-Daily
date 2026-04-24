public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // If lengths differ → not anagram
        if (s.length() != t.length()) return false;

        int[] freq = new int[26]; // for lowercase letters

        // Count characters in s
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Subtract using t
        for (char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        // Check if all are zero
        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();

        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car"));         // false
    }
}