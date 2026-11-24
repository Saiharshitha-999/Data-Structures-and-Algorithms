class Solution {
    public String removeDuplicates(String s) 
    {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;

        while(i < n)
        {
           if(!st.isEmpty() && s.charAt(i) == st.peek())
           {
             st.pop();
           }
           else
           {
              st.push(s.charAt(i));
           }
           i++;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : st)
        {
            sb.append(ch);
        }
        return sb.toString();

    }
}