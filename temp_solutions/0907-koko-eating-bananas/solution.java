class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,mid=-1,high=piles[0],answer=-1;
        for(int i=1;i<piles.length;i++)
        {
            if(piles[i]>high)
            {
                high=piles[i];
            }
        }
        while(low<=high)
        {
            mid=low+(high-low)/2;
            long total_time=0;
            for(int i=0;i<piles.length;i++)
            {
                total_time+=(int) Math.ceil((double)piles[i]/mid);
            }
            if(total_time<=h)
            {
                answer=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }

        }
        return answer;


        
    }
}
