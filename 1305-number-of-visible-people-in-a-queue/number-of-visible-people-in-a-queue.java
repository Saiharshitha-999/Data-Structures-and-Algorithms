class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] < heights[i]) {
                res[i]++;
                s.pop();
            }
            if (!s.isEmpty()) {
                res[i]++;
            }
            s.push(i);
        }

        return res;
    }
}
