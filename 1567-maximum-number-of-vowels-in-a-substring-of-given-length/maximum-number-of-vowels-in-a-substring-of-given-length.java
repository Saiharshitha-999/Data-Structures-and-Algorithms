class Solution {
    public int maxVowels(String s, int k) 
    {
        if(s.length() < k)
        {
           return 0;
        }
        int l = 0;
        int r = 0;
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        while(r < s.length())
        {
           if("aeiou".indexOf(s.charAt(r)) != -1)
           {
             count++;
           }
           if(r - l + 1 == k)
           {
               maxi = Math.max(count, maxi);

               if("aeiou".indexOf(s.charAt(l)) != -1)
               {
                count--;
               }
               l++;
           }
           r++;

        }
        return maxi;
    }
}