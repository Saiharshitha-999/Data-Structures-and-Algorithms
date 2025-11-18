class Solution {
    public int removeDuplicates(int[] nums)
    {
        //This is a two pointer technique
        //We use slow and fast pointer techinque
        int count=0;
        int i=0;//It is a slow pointer 
        for(int j=1;j<nums.length;j++) //It is a fast pointer which goes until the end of nums
        {
            if(nums[i]!=nums[j])   //For every new value we will update the slow pointer and then place the new value in that position
            {
                i++;
                nums[i]=nums[j];
                count++;
            } //If there is a duplicate value then do nothing and make sure to count the unique elements
        }
        return count+1;
        
    }
}
