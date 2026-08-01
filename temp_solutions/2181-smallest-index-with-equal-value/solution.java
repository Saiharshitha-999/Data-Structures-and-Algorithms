class Solution {
    public int smallestEqual(int[] nums) 
    {
        int smallestindex = -1;
        for(int i = 0 ;i < nums.length ; i++)
        {
            if(i%10 == nums[i])
            {
                smallestindex = i;
                break;
            }
        }
        return smallestindex;
    }
}
