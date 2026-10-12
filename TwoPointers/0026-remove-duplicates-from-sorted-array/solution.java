class Solution {
    public int removeDuplicates(int[] nums) 
    {
        if(nums.length == 1)
        {
            return 1;
        }
        int start = 0;
        int end = 1;
        int k = 1;
        while(end < nums.length)
        {
            if(nums[end] != nums[start])
            {
                start++;
                nums[start] = nums[end];
                k++;
            }
            end++;
        }
        return k;
    }
}
