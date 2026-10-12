class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int[] ans = new int[nums.length];
        int n = nums.length;
        int count = 1;
         
        ans[0] = 1;
        for(int i = 1 ; i < n; i++)
        {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int suffixsum = nums[n-1];
        for(int i = n - 2; i >= 0; i--)
        {
            ans[i] = suffixsum * ans[i];
            suffixsum *= nums[i];
        }
        return ans;
    }
}
