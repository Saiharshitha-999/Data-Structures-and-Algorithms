class Solution {
    public int countGoodTriplets(int[] nums, int a, int b, int c) {
        // Your frequency table for elements seen so far (the shopping cart)
        int[] freq = new int[1001]; 
        int triplets = 0;
        
        // Put the very first element into the shopping cart
        freq[nums[0]]++;
        
        // Loop 1: 'j' moves through the input array (acting as the middle element)
        for (int j = 1; j < nums.length - 1; j++) {
            
            // Loop 2: 'k' scans elements to the right of j
            for (int k = j + 1; k < nums.length; k++) {
                
                // Condition 2: Is the difference between j and k valid?
                if (Math.abs(nums[j] - nums[k]) <= b) {
                    
                    // Calculate the strict overlap range for past elements (i)
                    int m = Math.max(0, Math.max((nums[j] - a), (nums[k] - c)));
                    int n = Math.min(1000, Math.min((nums[j] + a), (nums[k] + c)));
                    
                    // Sum up how many valid 'i' elements are in our shopping cart
                    for (int val = m; val <= n; val++) {
                        triplets += freq[val];
                    }
                }
            }
            // Before moving j forward, toss the current nums[j] into the cart
            // so it can act as a past 'i' for future iterations!
            freq[nums[j]]++;
        }
        
        return triplets;
    }
}
