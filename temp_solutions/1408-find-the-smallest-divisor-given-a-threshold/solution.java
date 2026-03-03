class Solution {
    public int smallestDivisor(int[] arr, int threshold)
    {
        int n=arr.length;
        int min=1;
        int max=arr[0];

        for(int i=0;i<n;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
            
        }
        int low=min;
        int high=max;
        
        int ans=-1;
        int mid=-1;
        while(low<=high)
        {
            int count=0;
            mid=low+(high-low)/2;
            for(int i=0;i<n;i++)
            {
                count+=(int) Math.ceil((double)arr[i]/mid);
            }
        if(count<=threshold)
        {
            ans=mid;
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
        }  
    
    return ans;
}
}
