class Solution {
    public int findMin(int[] arr) {
         
        int size=arr.length;
        int low=0;
        int high=size-1;
        int ans = Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[low] <= arr[high])
            {
                ans = Math.min(ans,arr[low]);
                break;
            }
            if(arr[mid]>=arr[low])
           {
                ans = Math.min(arr[low],ans);
                low=mid+1;
           }
           else
           {
              ans = Math.min(arr[mid],ans);
              high = mid-1;
           }
       }
       return ans;
}
}
    

