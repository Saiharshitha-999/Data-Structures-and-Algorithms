class Solution {
    public int minDays(int[] nums, int m, int k) {
        
        int n = nums.length;
        int ans = -1;
        if((long)k * m > n)
        {
            return -1;
        }

        int left = Integer.MAX_VALUE;

        int right = 0;

        for(int x : nums)
        {
            left = Math.min(left,x);

            right = Math.max(right,x);
        }

         while(left <= right)
         {
            int mid = left + (right - left)/2;
            int count = 0;
            int bouquets = 0;
            for(int x : nums)
            {
                if(x <= mid)
                {
                    count++;
                }
                else{
                    count = 0;
                }
                if(count == k)
                {
                    bouquets++;
                    count = 0;
                }
            }
           
            if(bouquets >= m)
            {
                ans = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
         }
         return ans;
}
}
