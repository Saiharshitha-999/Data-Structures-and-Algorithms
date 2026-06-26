class Solution {

    public boolean isValid(String str) {

        Stack<Character> st = new Stack<>();

        int index = 0;

        while(index < str.length())
        {
            char ch = str.charAt(index);

            if(ch == '(' || ch == '[' || ch == '{')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }

                char top = st.peek();

                if((ch == ')' && top == '(') ||
                   (ch == ']' && top == '[') ||
                   (ch == '}' && top == '{'))
                {
                    st.pop();
                }
                else
                {
                    return false;
                }
            }

            index++;
        }

        return st.isEmpty();
    }
}
