import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> arr1 = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i > 0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int low = i+1;
            int high = n-1;
            while(low < high)
            {
                int sum = nums[i]+nums[low]+nums[high];
                if(sum==0)
                {
                    List<Integer> arr2 = new ArrayList<>();
                    arr2.addAll(Arrays.asList(nums[i],nums[low],nums[high]));
                    arr1.add(arr2);
                    low++;
                    high--;
                    while(low < high && nums[low]==nums[low-1])
                    {
                        low++;
                    }
                    while(low < high && nums[high]==nums[high+1])
                    {
                        high--;
                    }
                }
                else if(sum > 0)
                {
                    high--;
                }
                else
                {
                    low++;
                }
               
            }
        }
        return arr1;
    }
}
