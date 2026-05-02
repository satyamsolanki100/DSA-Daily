public class SumOfBeautyOfAllSubstrings {

    public int beautySum(String s) {

        int n = s.length();
        int totalBeauty = 0;

        // Generate all substrings
        for (int i = 0; i < n; i++) {

            int[] freq = new int[26]; // frequency array

            for (int j = i; j < n; j++) {

                // update frequency
                freq[s.charAt(j) - 'a']++;

                // find max and min frequency
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }

    public static void main(String[] args) {
        SumOfBeautyOfAllSubstrings obj = new SumOfBeautyOfAllSubstrings();

        System.out.println(obj.beautySum("aabcb"));   
        // Output: 5

        System.out.println(obj.beautySum("aabcbaa")); 
        // Output: 17
    }
}