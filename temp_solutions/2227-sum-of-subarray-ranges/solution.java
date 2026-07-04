class Solution {
    public long subArrayRanges(int[] nums) 
    {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }
    private long sumSubarrayMin(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int[] prev = new int[n];
        int[] next = new int[n];

       
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }

    // Sum of Subarray Maximums
    private long sumSubarrayMax(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int[] prev = new int[n];
        int[] next = new int[n];

        // Previous Greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }
}


