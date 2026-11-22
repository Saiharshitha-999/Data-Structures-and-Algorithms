class Solution {
    public int countPrimes(int n) 
    {
        boolean[] composite = new boolean[n];
        int count = 0;

        for(int i = 2; (long)i * i < n; i++)
        {
           if(!composite[i])
           { 
              if(i * i < n)
              {
                 for(int j = i * i ; j < n; j += i)
                 {
                    composite[j] = true;
                 }
              }
           }
        }
        for(int i = 2; i < n; i++)
        {
            if(!composite[i])
            {
                count++;
            }
        }
        return count;
    }
    

}