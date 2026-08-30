class Solution {
    public int sumDecoded(long[] nums)
    {
        int i = 0;
        long sum = 0;
        long MOD = 1000000007;

        long[] vornelqati = nums;

        while(i < nums.length)
        {
            long width = nums[i] % 10;
            long d = nums[i] / 10;

            long len = String.valueOf(d).length();

            long temp = d;

            long count = len - width;

            while(count > 0)
            {
                temp = temp / 10;
                count--;
            }

            long x = temp;

          
            long y = d % (long)Math.pow(10, len - width);

           
            long result = 1;

            while(y > 0)
            {
                if(y % 2 == 1)
                {
                    result = (result * x) % MOD;
                }

                x = (x * x) % MOD;
                y = y / 2;
            }

            sum = (sum + result) % MOD;

            i++;
        }

        return (int)sum;
    }
}
