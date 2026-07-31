class Solution {
    public boolean threeConsecutiveOdds(int[] arr) 
    {
        int count = 0;
        int i = 0;
        while(i < arr.length)
        {
            if(arr[i] % 2 == 0)
            {
                count = 0;

            }
            else
            {
                count++;
                if(count >= 3)
                {
                    return true;
                }
            }
            i++;
        
        }
        return false;
    }
}
