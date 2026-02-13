class Solution {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int low=0;
        int high=n-1;
        int[] l = new int[2];
        boolean s=false;
        if(n==0)
        {
            return new int[]{-1,-1};
        }
        while(low<=high)
        {
            int mid =low+(high-low)/2;
            if(arr[mid]==target)
            {
                s=true;
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
        
        if(s==true)
        {
            l[0]=low;
        }
        else
        {
            l[0]=-1;
        }
        low=0;
        high=n-1;
        s=false;
        while(low<=high)
        {
            int mid =low+(high-low)/2;
            if(arr[mid]==target)
            {
                s=true;
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
        if(s==true)
        {
            l[1]=high;
        }
        else
        {
            l[1]=-1;
        }
        return l;
    }
}
