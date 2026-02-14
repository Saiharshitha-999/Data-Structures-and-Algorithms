class Solution {
    public int[] searchRange(int[] arr, int target) {
        int size=arr.length;
        
        int low=0;
        int high=size-1;
        int n=-1,n1=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                n=mid;
                high=mid-1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        low=0;
        high=size-1;
         while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                n1=mid;
                low=mid+1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return new int[]{n,n1};


    
}
}

