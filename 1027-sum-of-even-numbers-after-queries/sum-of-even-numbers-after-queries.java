class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) 
    {
        int n = nums.length;
        int[] arr = new int[queries.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] % 2 == 0)
            {
              sum += nums[i];
            }
        }
        int j = 0;
        int k = 0;
        for(int[] l : queries)
        {
            int a = l[0];
            int b = l[1];
            if(b >= n)
            {
                arr[j++] = sum;
                continue;
            }
            int num1 = nums[b] + a;
            if((num1 & 1) == 0)
            {
                if(nums[b] % 2 == 0)
                {
                    sum -= nums[b];
                }
                sum += num1;
            }
            else if(nums[b] % 2 == 0)
            {
                sum -= nums[b];
            }
            nums[b] = num1;
            arr[j++] = sum;
        }
       return arr;
    }
}