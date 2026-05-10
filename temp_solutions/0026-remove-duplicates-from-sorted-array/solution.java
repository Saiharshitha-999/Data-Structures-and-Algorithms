class Solution {
    public int removeDuplicates(int[] arr)
    {
        
        int i = 0,j = 0;
        int n = arr.length;
        while(j < n)
        {
           if(arr[i]!=arr[j])
           {
            int temp=arr[i+1];
            arr[i+1]=arr[j];
            arr[j]=temp;
            i++;
           }
           j++;
        }
        return i+1;
        
    }
}
