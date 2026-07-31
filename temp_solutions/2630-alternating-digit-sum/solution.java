class Solution {
    public int alternateDigitSum(int n) 
    {
        if(n==1)
        {
            return 1;
        }
        int i = 1;
        int count = 0;
        while(n > 0)
        {
           int r = n % 10;
           if(i%2 == 0)
           {
             r = -r;
           }
           count += r;
           n = n/10;
           i++;
           
        }
        if((i-1)%2 == 0)
        {
            return -count;
        }
        return count;
    }
}
