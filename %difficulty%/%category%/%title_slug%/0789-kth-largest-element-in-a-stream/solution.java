class KthLargest {

    private int K;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) 
    {
        K = k;
        pq = new PriorityQueue<>();
        int initialElements = Math.min(k, nums.length);
        for(int i = 0; i < initialElements; i++)
        {
            pq.offer(nums[i]);
        }
        for(int i = k ;i < nums.length ;i++)
        {
            if(nums[i] > pq.peek())
            {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) 
    {
        
        if(pq.size() < K)
        {
          pq.offer(val);
          return pq.peek();
        }
        if(pq.peek() < val)
        {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
