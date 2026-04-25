import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap (sort by frequency descending)
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();

        System.out.println(obj.frequencySort("tree"));   // eert / eetr
        System.out.println(obj.frequencySort("cccaaa")); // cccaaa / aaaccc
        System.out.println(obj.frequencySort("Aabb"));   // bbAa / bbaA
    }
}