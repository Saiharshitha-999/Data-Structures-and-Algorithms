class Solution {
    public boolean sumOfNumberAndReverse(int num) 
    {
        if(num == 0)
        {
            return true;
        }
        for(int i = num/2 ; i < num; i++)
        {
            String s = String.valueOf(i);
            String sb = new StringBuilder(s).reverse().toString();
            if((i + Integer.parseInt(sb)) == num)
            {
                return true;
            }
        }
        return false;
    }
}