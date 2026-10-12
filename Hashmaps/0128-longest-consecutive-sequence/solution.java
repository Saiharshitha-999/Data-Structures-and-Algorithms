class Solution {
    public int longestConsecutive(int[] nums)
    {
        int n = nums.length;
        HashSet<Integer> arr = new HashSet<>();
        int count = 1;
        int m = 1;
        if(n==0)
        {
            return 0;
        }
        for(int i=0;i<n;i++)
        {
            arr.add(nums[i]);
        }
        for(int i:arr)
        {
            int value = i+1;

            if(arr.contains(i-1))
            {
                continue;
            }
            while(arr.contains(value))
            {
                    count++;
                    value++;
            }
            
            m = Math.max(m,count);
            count=1;
            
        }
        return m;
    }
}
