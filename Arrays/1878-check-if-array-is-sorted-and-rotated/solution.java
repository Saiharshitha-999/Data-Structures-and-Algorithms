class Solution {
    public boolean check(int[] nums) 
    {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++)
        {
           if(nums[i] > nums[(i + 1) % n])
           {
            count = count + 1;
           }
        }
        return count == 1 || count == 0;
    }
}
