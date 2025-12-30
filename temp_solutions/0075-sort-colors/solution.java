class Solution {
    public void sortColors(int[] nums) {
        int i=0,mid=0,j=nums.length-1;
        while(mid<=j)
        {
            if(nums[mid]==0)
            {
                int temp=nums[i];
                nums[i]=nums[mid];
                nums[mid]=temp;
                i++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;

            }
            else if(nums[mid]==2)
            {
                int temp=nums[j];
                nums[j]=nums[mid];
                nums[mid]=temp;
                j--;
            }
        }
    }
}
