class Solution {
    public int[] distinctDifferenceArray(int[] nums) 
    {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];

        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < nums.length; i++)
        {   
            set.add(nums[i]);
            prefix[i] = set.size();
        }

        set.clear();

        for(int j = n - 1; j >= 0; j--)
        {
             suffix[j] = set.size();
             set.add(nums[j]);
        }

        for(int i = 0; i < nums.length; i++)
        {
            ans[i] = prefix[i] - suffix[i];
        }
        return ans;

        
    }
}