class Solution {
    public int[] sumZero(int n)
    {
       
       if(n == 2)
       {
          return new int[]{-1,1};
       }
       int[] arr = new int[n];
       int sum = 0;
       for(int i = 0; i < n - 2; i++)
       {
         arr[i] = i+1;
         sum += arr[i];
       }
       arr[n - 1] = -sum;
       return arr; 
    }
}
