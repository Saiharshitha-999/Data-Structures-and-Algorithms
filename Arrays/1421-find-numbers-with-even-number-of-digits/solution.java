class Solution {
    public int findNumbers(int[] nums) {
        
        int a = nums.length, count=0,b=0,c=0;
    for(int i=0;i<a;i++)
    {
        b=nums[i];
        c = (int) Math.log10(b) + 1;
            
            if (c % 2 == 0) {
                count++;
        }
    }
    return count;
    }
} 
