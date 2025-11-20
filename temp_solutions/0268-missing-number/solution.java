class Solution {
    public int missingNumber(int[] nums)
    {
        Arrays.sort(nums);
        int n1=nums.length+1;
        int[] a=new int[n1];
        for(int i=0;i<n1;i++)
        {
            a[i]=i;
        }
        int j=0;
        for(int i=0;i<n1;i++)
        {
            if(nums.length==j)
            {
                return i;
            }
            if(a[i]!=nums[j])
            {
                return i;
            }
            j++;
        }
        return -1;
    }
}
