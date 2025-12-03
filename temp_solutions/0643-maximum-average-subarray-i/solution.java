class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max_average=0;
        double sums=0;
        for(int i=0;i<k;i++)
        {
            sums+=nums[i];
        }
        max_average=sums;
        for(int i=1;i<=nums.length-k;i++)
        {
            
            sums=sums+nums[k+i-1]-nums[i-1];
            if(max_average<sums)
            {
                max_average=sums;
            }
            
        }
        return max_average/k;
    }
}
