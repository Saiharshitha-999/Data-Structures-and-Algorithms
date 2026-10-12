class Solution {
    public int[] nextGreaterElements(int[] arr) 
    {
        Stack<Integer> st = new Stack<>();
        int[] a = new int[arr.length];
        for(int i = 2 *arr.length-1 ; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= arr[i%arr.length])
            {
                st.pop();
            }
            if(i < arr.length)
            {
            if(st.isEmpty())
            {
                a[i%arr.length] = -1;
            }
            else
            {
                a[i] = st.peek();
            }
            }
            st.push(arr[i%arr.length]);

        }
        
        return a;
    }
}
