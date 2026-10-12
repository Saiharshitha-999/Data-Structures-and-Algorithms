class Solution {
    public int smallestDivisor(int[] nums, int limit)
    {
        int n = nums.length;
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int num : nums)
        {
            right = Math.max(right,num);
        }
       int ans = 0;
       while(left<=right)
       {
          int mid = left + (right - left)/2;
          int sum = 0;
          for(int i = 0; i < n; i++)
          {
              sum+=Math.ceil((double)nums[i]/mid);
          }
          if(sum <= limit)
          {
            right = mid-1;
            ans = mid;
          }
          else
          {
              left = mid+1;
          }
       }
       return ans;
}
}
