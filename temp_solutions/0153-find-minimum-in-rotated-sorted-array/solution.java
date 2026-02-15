class Solution {
    public int findMin(int[] arr) {
         
        int size=arr.length;
        int low=0;
        int high=size-1;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]<=arr[high])
           {
                high=mid;
           }
           else
           {
              low=mid+1;
           }
       }
       return arr[high];
}
}
    

