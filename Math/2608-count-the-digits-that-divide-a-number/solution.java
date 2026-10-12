class Solution {
    public int countDigits(int num) 
    {
        int original = num;
        if(num == 1)
        {
            return 1;
        }
        int count = 0;
        while(num > 0)
        {
           int r = num%10;
           if(original % r == 0)
           {
              count++;
           }
           num = num/10;
        }
        return count;
    }
}
