class Solution {
    public int[] sortedSquares(int[] nums) {
        int j=nums.length-1;
        int[] nums1=new int[nums.length];
        int k=nums.length-1,i=0;
        while(i<=j)
        {
            int left=nums[i]*nums[i];
            int right=nums[j]*nums[j];
            if(left>right)
            {
               nums1[k]=left;
               i++;
            }
            else if(left<=right)
            {
                nums1[k]=right;
                j--;
            }
            k--;
        }
        return nums1;
    }
}
