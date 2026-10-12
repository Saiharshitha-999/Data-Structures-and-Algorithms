class Solution {
    public int beautySum(String s) 
    {
        int ans = 0;
        for(int i = 0;i < s.length(); i++)
        {
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++)
            {
                freq[s.charAt(j)-'a']++;
                ans += frequency(freq);

            }
        }
        return ans;
    }
    public int frequency(int[] freq)
    {
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for(int x : freq)
        {

            if(x > 0)
            {
                if(x > maxFreq)
                {
                    maxFreq = x;
                }

                if(x < minFreq)
                {
                    minFreq = x;
                }
            }
        }
        return maxFreq - minFreq;
        
    }
    
}
