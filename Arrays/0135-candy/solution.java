class Solution {
    public int candy(int[] rating) 
    {

        int n = rating.length;
        if(n == 1)
        {
            return 1;
        }
        int[] candies = new int[n]; 
       Arrays.fill(candies,1);
       for(int i = 1 ; i < n ;i++)
       {
        if(rating[i] > rating[i-1])
        {
            candies[i] = candies[i-1]+1;
        }
       }
       for(int i = n-2 ; i >= 0;i--)
       {
        if(rating[i] > rating[i + 1])
        {
            candies[i] = Math.max(candies[i], candies[i+1] + 1);
        }
       }
       int total = 0;
       for(int i : candies)
       {
        total += i;
       }
       return total;
    }
}
