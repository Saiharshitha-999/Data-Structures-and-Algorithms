class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length ;
        int[] res = new int[n - k + 1];
        int j = 0;
        int l = 0;

        for(int r = 0; r < n; r++)
        {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r])
            {
                dq.pollLast();
            }

            dq.offerLast(r);

            if(dq.peekFirst() < l)
            {
                 dq.pollFirst(); 
            }

            if(r - l + 1 == k)
            {
                int value = nums[dq.peekFirst()];
                res[j] = value;
                j++;
                l++; 
            }
        }
        return res;
    }
}