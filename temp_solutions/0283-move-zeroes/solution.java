class Solution {
    public void moveZeroes(int[] nums) {
         int i,j;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                
                break;
            }
        }
        for(j=i+1;j<nums.length;j++)
        {
            if(nums[j]!=0)
            {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
        
        }
        
    
}
}
