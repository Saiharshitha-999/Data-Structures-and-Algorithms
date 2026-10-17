class Solution {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1000000007;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element
        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                pse[i] = -1;
            }
            else
            {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next Smaller Element
        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                nse[i] = n;
            }
            else
            {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        long ans = 0;

        for(int i = 0; i < n; i++)
        {
            long left = i - pse[i];
            long right = nse[i] - i;

            ans = (ans + (left * right * arr[i]) % mod) % mod;
        }

        return (int) ans;
    }
}
