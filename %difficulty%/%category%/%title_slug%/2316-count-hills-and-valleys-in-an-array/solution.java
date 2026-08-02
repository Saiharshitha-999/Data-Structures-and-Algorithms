class Solution {
    public int countHillValley(int[] nums) 
    {
        int left = nums[0];
        int i = 1;
        int totalcount = 0;
        while(i < nums.length - 1)
        {
            while(i < nums.length - 1 && nums[i] == nums[i-1])
            {
                i++;
                continue;
            }

            if (i >= nums.length - 1)
                break;

           int j = i+1;
           while(j < nums.length && nums[i] == nums[j])
           {
              j++;
           }
            if (j == nums.length)
                break;

           int right = nums[j];
           if(left < nums[i] && right < nums[i])
           {
              totalcount += 1;
           }
           else if(left > nums[i] && right > nums[i])
           {
              totalcount += 1;
           }
           left = nums[i];
           i++;
           
        }
        return totalcount;
    }
        
    
}
