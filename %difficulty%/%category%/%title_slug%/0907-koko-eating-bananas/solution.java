class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int left = 1;
        int right = 0;
        int ans = 0;
        int n = nums.length;
        for(int num : nums)
        {
            right = Math.max(right,num);
        }
        long hour = 0;
        while(left <= right)
        {
           int mid = left + (right-left)/2;
           hour = 0;
           for(int i=0;i<n;i++)
           {
            hour += ((long)nums[i]+mid-1)/mid;
           }
            
            if(hour<=h)
            {
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }

        }
        return ans;
    }
}
