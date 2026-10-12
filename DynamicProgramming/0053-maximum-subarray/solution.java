class Solution {
    public int maxSubArray(int[] nums) 
    {
        int end = 1;
        int n = nums.length;
        int sum = nums[0];
        int maxi = nums[0];
        while(end < n)
        {
            maxi = Math.max(maxi,sum);
            if(sum < 0)
            {
                sum = 0;   
            }
            sum += nums[end];
            end++;
        }
        maxi = Math.max(maxi,sum);
        return maxi;
    }
}
