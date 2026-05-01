import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        // Step 3: Build result
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency obj = new SortCharactersByFrequency();

        System.out.println(obj.frequencySort("tree"));    
        // Output: eert (or eetr)

        System.out.println(obj.frequencySort("cccaaa"));  
        // Output: cccaaa or aaaccc

        System.out.println(obj.frequencySort("Aabb"));    
        // Output: bbAa (or bbaA)
    }
}