class Solution {
    public boolean search(int[] arr, int target) {
        
        int size=arr.length;
        int low=0;
        int high=size-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
            }
           else if(arr[mid]<=arr[high])
           {
                if(target>=arr[mid] && target<=arr[high])
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
              if(target<=arr[mid] && target>=arr[low])
              {
                high=mid-1;

              }
              else
              {
                low=mid+1;
              }
           }
       }
       return false;
}
}
