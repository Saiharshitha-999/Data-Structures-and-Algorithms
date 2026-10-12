class Solution {
    public int shipWithinDays(int[] arr, int days) 
    {
        int max=0;
        int max1=arr[0];
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
           max+=arr[i];
           if(max1<arr[i])
           {
            max1=arr[i];
           }
        }
        int low=max1;
        int high=max;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int sum=0;
            int j=1;
            for(int i=0;i<n;i++)
            {
                sum+=arr[i];
                if(sum>mid)
                {
                    j++;
                    sum=arr[i];
                }

            }
            if(j>days)
            {
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }

        }
        return ans;
    }
}
