class Solution {
    public String removeKdigits(String nums, int k) 
    {
       Stack<Integer> st = new Stack<>();
       char[] c = nums.toCharArray();
       for(int i = 0 ;i < c.length; i++)
       {
         int value = c[i] - '0';
           
           while(k > 0 && !st.isEmpty() && (st.peek() > value))
           {
              st.pop();
              k--;
           }
           
           st.push(value);
           
           
       }
       while(k > 0)
       {
         st.pop();
         k--;
       }
       

       StringBuilder sb = new StringBuilder();

        for(int digit : st)
        {
            sb.append(digit);
        }
        while(sb.length()!=0 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0)
       {
          return "0";
       }

       String ans = sb.toString();
       return ans;
    }
}
