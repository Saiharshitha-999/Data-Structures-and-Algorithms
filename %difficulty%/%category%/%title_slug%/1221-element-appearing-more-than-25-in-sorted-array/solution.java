class Solution {
    public int findSpecialInteger(int[] arr) 
    {
        int n = arr.length;
        int boundary = (int)(n * 0.25);
        int num = arr[0];
        int sum = 1;
        for(int i = 1; i < arr.length ; i++)
        {
            if(sum > boundary)
            {
                return num;
            }
            if(arr[i] == num)
            {
                sum++;
            }
            else
            {
                sum = 1;
                num = arr[i];
            }
            
        }
        return num;
    }
}
