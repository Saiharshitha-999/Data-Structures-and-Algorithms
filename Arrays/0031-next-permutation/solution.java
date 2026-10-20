class Solution {
    public void nextPermutation(int[] nums) 
    {
        int n = nums.length;
        int num1 = -1;
        for(int i = n - 1; i > 0; i--)
        {
            if(nums[i] > nums[i - 1])
            {
               num1 = i - 1;
               break;
            }
        }
        if(num1 != -1)
        {
            for(int i = n - 1; i > num1; i--)
            {
                if(nums[num1] < nums[i])
                {
                    int temp = nums[num1];
                    nums[num1] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        int left = num1 + 1;
        int right = n - 1;
        while(left <= right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }
}
