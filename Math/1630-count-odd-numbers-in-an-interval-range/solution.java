class Solution {
    public int countOdds(int low, int high) 
    {
        int a = 0;
        if(low%2 == 0 && high%2 == 0)
        {
           a = high - low;
        }else if(low % 2 != 0 && high%2 != 0)
        {
            a = high - low +2;
        }
        else
        {
            a = high - low + 1;
        }
        return a/2;

    }
}
