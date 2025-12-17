class Solution {
    public int missingNumber(int[] nums)
    {
        int XOR=0;
        for(int i=0;i<nums.length+1;i++)
        {
            XOR^=i;
        }
        for(int i=0;i<nums.length;i++)
        {
            XOR^=nums[i];
        }
        return XOR;
    }
}
