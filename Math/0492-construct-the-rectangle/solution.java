class Solution {
    public int[] constructRectangle(int area) 
    {
        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 1; i <= area; i++)
        {
            if(area % i == 0 && i >= area/i)
            {
               int val = area/i;
               if(min > i - val)
               {
                min = i-val;
                ans1 = i;
                ans2 = val;
               }
            }
        }
        return new int[]{ans1,ans2};
    }
}
