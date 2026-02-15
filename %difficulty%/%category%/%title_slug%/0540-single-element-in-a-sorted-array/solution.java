class Solution {
    public int singleNonDuplicate(int[] arr) {
        int size=arr.length;
        int low=0;
        int high=size-1;
        int mid=-1;
        while(low<high)
        {
            mid=low+(high-low)/2;
            if(mid%2!=0)
            {
                if(mid!=0 && arr[mid]==arr[mid-1])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            else
            {
                if(mid!=size-1 && arr[mid]==arr[mid+1])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid;
                }
            }
        }
        return arr[low];
    }
}
