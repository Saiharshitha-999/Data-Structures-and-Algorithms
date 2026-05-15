class Solution {
    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = prices.length;
        for(int i=0;i<n;i++)
        {
            if(min > prices[i])
            {
                min = prices[i];
            }
            if(prices[i] - min > max)
            {
                max = prices[i] - min;
            }
        }
        return max;
        
    }
}
