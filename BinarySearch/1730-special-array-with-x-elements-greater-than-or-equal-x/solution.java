class Solution {
    public int specialArray(int[] nums) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 1; i <= nums.length; i++)
        {
            int m = n - binarySearch(nums,i);
            if(m == i)
            {
                return i;
            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length-1;
        int firstIdx = nums.length;
        while(left <= right)
        {
            int mid = (left) + (right - left)/2;
            
            if(nums[mid] >= target)
            {
                firstIdx = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return firstIdx;
    }
}
