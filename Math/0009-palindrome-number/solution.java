class Solution {
    public boolean isPalindrome(int x) 
    {
        if((x%10 == 0 && x != 0 ) || x < 0)
        {
            return false;
        }
        int sum = 0;
        int original = x;
        while(x > sum)
        {
           int r = x%10;
           sum = sum*10+ r;
           x = x/10;
        }
        if(sum == x|| sum/10 == x)
        {
            return true;
        }
        return false;
    }
}

