class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int first = -1;
        int last = -1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
            {
                right=mid-1;
                first = mid;
            }
            else if(nums[mid]<target)
            {
                left = mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        left=0;
        right=n-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
            {
                left = mid+1;
                last = mid;
            }
            else if(nums[mid]<target)
            {
                 left = mid+1;
                
            }
            else
            {
                right=mid-1;
            }
        }
        return new int[]{first,last};
}
}
