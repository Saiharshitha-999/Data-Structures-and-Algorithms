class Solution {
    public int minDays(int[] arr, int m, int k) {
        
       
        int n=arr.length;
        int min=arr[0];
        int max=arr[0];
        for(int i=0;i<n;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        int low=min;
        int high=max;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int count=0;
            int j=0;
            for(int i=0;i<n;i++)
            {
                if(arr[i]<=mid)
                {
                    count+=1;
                }
                else
                {
                    j+=(count/k);
                    count=0;
                }
            }
            j+=(count/k);
            if(j>=m)
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
