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
        String a = "";
        while(!st.isEmpty())
        {
            a += st.pop();
        }
        n = a.length();
        for(i = 0; i < n; i++)
        {
            st.push(a.charAt(i));
        }
        a = "";
        while(!st.isEmpty())
        {
            a += st.pop();
        }
        return a;

    }
}