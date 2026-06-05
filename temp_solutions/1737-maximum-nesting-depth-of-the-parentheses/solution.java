class Solution {
    public int maxDepth(String s) 
    {
        int count = 0;
        int m = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
            {
                count++;
            }
            else if(ch==')')
            {
               m = Math.max(m,count);
               count--;
            }
        }
        return m;

    }
}
