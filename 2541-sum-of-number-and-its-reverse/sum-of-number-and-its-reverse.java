class Solution {
    public boolean sumOfNumberAndReverse(int num) 
    {
        if(num == 0)
        {
            return true;
        }
        for(int i = num/2; i < num; i++)
        {
            if((i + reverse(i)) == num)
            {
                return true;
            }
        }
        return false;
    }
    public int reverse(int num)
    {
        int n = 0;
        while(num > 0)
        {
           int r = num % 10;
           n = n * 10 + r;
           num = num/10;
        }
        return n;
    }
}