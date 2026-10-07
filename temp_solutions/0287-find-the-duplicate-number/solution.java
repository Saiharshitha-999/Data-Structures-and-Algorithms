class Solution {
    public int findDuplicate(int[] nums) 
    {
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];          // Moves 1 step
            hare = nums[nums[hare]];            // Moves 2 steps
        } while (tortoise != hare);
        
        // Phase 2: Find the entrance to the cycle (the duplicate number)
        tortoise = nums[0];                     // Reset tortoise to the start
        while (tortoise != hare) {
            tortoise = nums[tortoise];          // Both move 1 step now
            hare = nums[hare];
        }
        
        return tortoise;
    }
}
