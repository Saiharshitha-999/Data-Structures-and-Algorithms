class Solution {
    public int numPrimeArrangements(int n) 
    {
        int primecount = 0;
        long mod = 1000000007L;
        int consecutivecount = 0;
        for(int i = 1; i <= n; i++)
        {
            if(isprime(i))
            {
                primecount++;
            }
        }
        long result = 1;
        consecutivecount = n - primecount;
        for(int i = primecount; i >= 1; i--)
        {
          result = (result * i) % mod;
        }
        for(int i = consecutivecount; i >= 1; i--)
        {
          result = (result * i) % mod;
        }
        return (int)result;


    }
    public boolean isprime(int n)
    {
       if(n <= 1)
       {
        return false;
       }
       for(int i = 2; i * i <= n; i++)
       {
         if(n % i == 0)
         {
            return false;
         }
       }
       return true;
    }
}
