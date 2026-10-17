class Solution {

    public long weightedSum(int[] parent, int[] nums) {

        int n = parent.length;
        long[] depth = new long[n];

        Arrays.fill(depth, -1);

        depth[0] = 1;
        long height = 1;

        for (int i = 0; i < n; i++) 
        {
            depth[i] = findDepth(i, parent, depth);
            height = Math.max(height, depth[i]);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {

            answer += (long) nums[i]
                    * (height - depth[i] + 1);
        }

        return answer;
    }

    private long findDepth(
        int node,
        int[] parent,
        long[] depth
    ) {

        
        if (depth[node] != -1) {
            return depth[node];
        }

        depth[node] =
            findDepth(parent[node], parent, depth) + 1;

        return depth[node];
    }
}
