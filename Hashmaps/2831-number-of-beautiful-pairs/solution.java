class Solution {
    public int countBeautifulPairs(int[] nums) 
    {
        int count = 0;
        int[] firstdigit = new int[10];
        for(int i = 0 ;i < nums.length; i++)
        {
            int last = nums[i]%10;
            for(int j = 1; j <= 9; j++)
            {
                if(GCD(j,last) == 1)
                {
                    count+=firstdigit[j];
                }
            }
            int first = nums[i];
            while(first >= 10)
            {
                first /= 10;
            }
            firstdigit[first]++;
        }
        return count;
    }
    public int GCD(int a ,int b)
    {
        if(b == 0)
        {
            return a;
        }
        return GCD(b,a%b);
    }
}
