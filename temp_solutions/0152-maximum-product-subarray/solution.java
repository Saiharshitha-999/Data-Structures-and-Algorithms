class Solution {
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int m = Integer.MIN_VALUE;
        for(int i = 0;i < n; i++)
        { 
            prefix*=nums[i];
            suffix*=nums[n-i-1];
            m = Math.max(m,Math.max(prefix,suffix));
            if(prefix==0)
            {
                prefix=1;
            }
            if(suffix==0)
            {
                suffix=1;
            }
        }
        return m;
    }
}
