class Solution {
    public int[] replaceElements(int[] arr) 
    {
        int max = Integer.MIN_VALUE;
        int n = arr.length - 1;
        for(int i = n; i >= 0; i--)
        {
            int current = arr[i];
            arr[i] = max;
            if(max < current)
             {
                max = current;
             }
            
        }
        arr[n] = -1;
        return arr;
    }
}
