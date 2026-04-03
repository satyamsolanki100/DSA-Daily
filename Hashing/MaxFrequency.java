import java.util.*;

class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        long sum = 0;
        int left = 0;
        int maxFreq = 1;
        
        for (int right = 0; right < nums.length; right++) {
            
            sum += nums[right];
            
            // Check if window is valid
            while ((long)(right - left + 1) * nums[right] - sum > k) {
                sum -= nums[left];
                left++;
            }
            
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        
        return maxFreq;
    }
}