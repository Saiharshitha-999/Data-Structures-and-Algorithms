class Solution {
    public int minDays(int[] arr, int m, int k) {
        
        // let us sort the array for the maximum element 
        // let us declare and initiaize the array to -1
        int n=arr.length;
        int min=arr[0];
        int max=arr[0];
        if(n<(long)m*k)
        {
            return -1;
        }
        for(int i=0;i<n;i++)
        {
          if(max<arr[i])
          {
            max=arr[i];
          }
          if(min>arr[i])
          {
            min=arr[i];
          }
        }
        int low=min,high=max;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int i=0;
            int j=0;
            int count=0;
            while(i<n)
            {
        
                if(arr[i]<=mid)
                {
                    j++;
                     
                }
                else
                {
                    count+=(j/k);
                    j=0;
                }
                i++;

            }
            count += (j / k);
            if(count<m)
            {
               low=mid+1;
            }
            else
            {
                high=mid-1;
                ans=mid;
            }
            

        }
        return ans;
    }
}
