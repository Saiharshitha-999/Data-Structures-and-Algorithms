class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            // Rule 1 & 2: A valid subarray MUST start with an even number <= threshold
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                int start = i;
                i++; // Move to the next element to check alternating pattern
                
                // Keep expanding the subarray as long as it alternates and stays <= threshold
                while (i < n && nums[i] <= threshold && nums[i] % 2 != nums[i - 1] % 2) {
                    i++;
                }
                
                // Record the maximum length found so far
                maxLen = Math.max(maxLen, i - start);
            } else {
                // If it's not a valid starting point, just move forward
                i++;
            }
        }
        
        return maxLen;
    }
}
