class Solution {
    public int removeElement(int[] arr, int val) {
        int i,c=0;
         for(i=0;i<arr.length;i++)
         {
            if(arr[i]==val)
            {
                break;
            }
            c++;
         }
         int j=i+1;
        while(j<arr.length)
        {
            if(arr[j]!=val)
            {
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
                c++;
            }
            j++;
        }
        return c;
    }
}
