class Solution {
    public String removeOuterParentheses(String s) 
    {
        StringBuilder str = new StringBuilder();
        int count = 0;
        for(char x : s.toCharArray())
        {
           if(count == 0)
           {
              count++;
           }
           else if(count>0)
           {
                if(x == '(')
                {
                    str.append(x);
                    count++;
                }
                else
                {
                    count--;
                    if(count >0 )
                    {
                    str.append(x);
                    }
                }
           }
        }
        return str.toString();
    }
}
