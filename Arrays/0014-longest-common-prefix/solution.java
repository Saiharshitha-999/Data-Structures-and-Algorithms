class Solution {
    public String longestCommonPrefix(String[] str) 
    {
        int prefix = str[0].length();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < prefix; i++)
        {
            char c = str[0].charAt(i);
            for(int j = 1; j < str.length; j++)
            {
                if(i >= str[j].length() || str[j].charAt(i)!=c)
                {
                    return ans.toString();
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
